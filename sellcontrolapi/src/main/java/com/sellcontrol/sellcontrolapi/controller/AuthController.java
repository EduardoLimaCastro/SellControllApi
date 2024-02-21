package com.sellcontrol.sellcontrolapi.controller;

import com.sellcontrol.sellcontrolapi.domain.site_users.dto.DataAuth;
import com.sellcontrol.sellcontrolapi.domain.site_users.model.Site_Users;
import com.sellcontrol.sellcontrolapi.infra.security.JWTTokenData;
import com.sellcontrol.sellcontrolapi.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager auth;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuth data){
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = auth.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((Site_Users) authentication.getPrincipal());
        return ResponseEntity.ok(new JWTTokenData(tokenJWT));
    }
}

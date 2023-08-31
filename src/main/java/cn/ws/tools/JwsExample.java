package cn.ws.tools;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class JwsExample {
    public static void main(String[] args) throws Exception {
        // 读取私钥
        String privateKeyString = "-----BEGIN CERTIFICATE-----\n"
                + "MIIFbTCCBFWgAwIBAgIQeeQMLxpH89sScSOBtnMSyjANBgkqhkiG9w0BAQsFADBGMQswCQYDVQQGEwJVUzEiMCAGA1UEChMZR29vZ2xlIFRydXN0IFNlcnZpY2VzIExMQzETMBEGA1UEAxMKR1RTIENBIDFENDAeFw0yMzA1MzAwODEwNThaFw0yMzA4MjgwODEwNTdaMB0xGzAZBgNVBAMTEmF0dGVzdC5hbmRyb2lkLmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJTU6GjHddOqsmKs9NVxZamLllBRy+5Emy18nYZCYPUS8sS32HSALcJqnTClJWtLd6/heo4WzIVPEhUTZFCt8vkq/iFXNhKbMTKA5Q/NH43XFuTXVpN78ozjcR5zTh8A5/fFawt1TgfuSk75UG32nY79UKgzSKPfZkXk1Ax0D9E9iTmN7dirKoMoBUQNBOKDGkAin7yBNDHQn7CNwS7FBZ+aRXPeznSwypfKDcvbQ9L0gzkCmQYcPvglz5Slktd+aYo7vDkB6xKpMd6q48C2+ky3wIRmAJvBcs8bQ9eGgPQcNjNkzMKweC52/FUCvBirT2NVFZCEIdmMg9xb0Kx5tR0CAwEAAaOCAn4wggJ6MA4GA1UdDwEB/wQEAwIFoDATBgNVHSUEDDAKBggrBgEFBQcDATAMBgNVHRMBAf8EAjAAMB0GA1UdDgQWBBTPQRIsCx/34YNo1I3apKYMo8fBojAfBgNVHSMEGDAWgBQl4hgOsleRlCrl1F2GkIPeU7O4kjB7BggrBgEFBQcBAQRvMG0wOAYIKwYBBQUHMAGGLGh0dHA6Ly9vY3NwLnBraS5nb29nL3MvZ3RzMWQ0aW50L0JUSWNjRFFzaERRMDEGCCsGAQUFBzAChiVodHRwOi8vcGtpLmdvb2cvcmVwby9jZXJ0cy9ndHMxZDQuZGVyMB0GA1UdEQQWMBSCEmF0dGVzdC5hbmRyb2lkLmNvbTAhBgNVHSAEGjAYMAgGBmeBDAECATAMBgorBgEEAdZ5AgUDMD8GA1UdHwQ4MDYwNKAyoDCGLmh0dHA6Ly9jcmxzLnBraS5nb29nL2d0czFkNGludC9YMkoySHJfN1BpTS5jcmwwggEDBgorBgEEAdZ5AgQCBIH0BIHxAO8AdQCt9776fP8QyIudPZwePhhqtGcpXc+xDCTKhYY069yCigAAAYhr7M0KAAAEAwBGMEQCIGq4zOeNY7A/urvNV6qvqUI4mqaS5mTJ0tQ066bUXykDAiBxIMr/BSIZd/PT6giD+yCuHDeJuICsIJnwmT8Z4zps/wB2ALNzdwfhhFD4Y4bWBancEQlKeS2xZwwLh9zwAw55NqWaAAABiGvsySwAAAQDAEcwRQIgfrJGRWm6SIhx47DlF+9UmCseED9rv9MRJV1CR498ZusCIQCAkm27ABJa+YRAy3xo31yrw0NrZ164TC79/zdEpU4pZjANBgkqhkiG9w0BAQsFAAOCAQEAcsdmbSXM/YpV65AC9PZtJxbY5MsxBCFCd3cV2TI22+ch/oQx+gADQe2brmk7jXE/4G9jJCN/voebltLFVInlh8vTYfFNqgOs4ZEZr4HMGdvDmUbPAmwLZJF4UE97MFS00cgy5aXyuZm5Hep/l0wI0EYP78NgPXuR9sknGfG1h+sA3uMD+G+lrBnuwwNXo0EpgnBwl8gFTvdJLBsRbChYPTTPppHRsrQQ8TDCyYFS/sU/Y70M4062Dh3r1+fAo/B95ptSTNciuLkH/SGGXQArO/q+mLtXyIChJfRPH3bBR+edYvRT5CII/B31mCojwjGnxOwcmdwALXK28TI8WkW1cQ==\n"
                + "-----END CERTIFICATE-----";

        // 解析私钥
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // 创建JWS
        String jws = Jwts.builder()
                .setSubject("example")
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();

        System.out.println("JWS: " + jws);

        // 验证JWS
        Jws<Claims> parsedJws = Jwts.parserBuilder()
                .setSigningKey(privateKey)
                .build()
                .parseClaimsJws(jws);

        System.out.println("JWS验证通过");
        System.out.println("Subject: " + parsedJws.getBody().getSubject());
    }
}

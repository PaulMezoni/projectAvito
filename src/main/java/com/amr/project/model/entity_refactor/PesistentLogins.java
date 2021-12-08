package com.amr.project.model.entity_refactor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class PesistentLogins {

    @Id
    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime lastUsed;
}

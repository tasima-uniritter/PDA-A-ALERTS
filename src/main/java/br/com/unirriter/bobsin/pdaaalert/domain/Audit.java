package br.com.unirriter.bobsin.pdaaalert.domain;

import br.com.unirriter.bobsin.pdaaalert.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AUDIT")

public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUDIT_ID")
    private Long auditId;

    @Column(name = "METRIC_CONTENT", columnDefinition = "CLOB")
    private String metricContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENGINEER_ID")
    private Engineer engineer;

    @Column(name = "TRIGGER_TIMESTAMP")
    private LocalDateTime triggerTimestamp;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private NotificationStatus status;

    @Column(name = "MESSAGE", columnDefinition = "CLOB")
    private String message;
}

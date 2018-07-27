package br.com.unirriter.bobsin.pdaaalert.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.unirriter.bobsin.pdaaalert.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  Uma Audit é uma tabela que grava todos os eventos de alerta, enviados ou não, aos Engineer.
  Deve registrar a mensagem que foi recebida na fila dos monitors-alerts, bem como a quem foi enviado o alerta (Engineer).
*/

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

    @Column(name = "AUDIT_METRIC_CONTENT", columnDefinition = "CLOB")
    private String auditMetricContent;

    @Column(name = "AUDIT_TRIGGER_TIMESTAMP")
    private LocalDateTime auditTriggerTimestamp;

    @Enumerated(EnumType.STRING)
    @Column(name = "AUDIT_STATUS")
    private NotificationStatus auditStatus;

    @Column(name = "AUDIT_MESSAGE", columnDefinition = "CLOB")
    private String auditMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENGINEER_ID")
    private Engineer engineerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "METRIC_ID")
    private Metric metricId;
}

package com.zmdev.goldenbag.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 考核記錄
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "user_id")
    private User user;

    // 季度ID
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "quarter_id")
    private Quarter quarter;

    @OneToMany(mappedBy = "assessment")
    private List<AssessmentProjectScore> assessmentProjectScores;

    @OneToMany(mappedBy = "assessment")
    private List<AssessmentInputContent> assessmentInputContents;

    @ManyToOne
    private AssessmentTemplate assessmentTemplate;

    // 間接經理審核意見
    private String indirectManagerAuditComments;

    // 直接經理評價
    private String directManagerEvaluation;

    // 职级系数
    @Column(nullable = true)
    private Double rankCoefficient;

    // 时间系数
    @Column(nullable = true)
    private Double timeCoefficient;

    // 自评得分总和
    @Column(nullable = true)
    private Integer totalSelfScore;

    // 经理评分总和
    @Column(nullable = true)
    private Integer totalManagerScore;

    @Enumerated(EnumType.STRING)
    private Status status;

    // 季度奖金
    @Column(nullable = true)
    private Double quarterlyBonus;

    @LastModifiedDate
    private Date updatedAt;

    @CreatedDate
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AssessmentProjectScore> getAssessmentProjectScores() {
        return assessmentProjectScores;
    }

    public void setAssessmentProjectScores(List<AssessmentProjectScore> assessmentProjectScores) {
        this.assessmentProjectScores = assessmentProjectScores;
    }

    public List<AssessmentInputContent> getAssessmentInputContents() {
        return assessmentInputContents;
    }

    public void setAssessmentInputContents(List<AssessmentInputContent> assessmentInputContents) {
        this.assessmentInputContents = assessmentInputContents;
    }

    public String getDirectManagerEvaluation() {
        return directManagerEvaluation;
    }

    public void setDirectManagerEvaluation(String directManagerEvaluation) {
        this.directManagerEvaluation = directManagerEvaluation;
    }

    public AssessmentTemplate getAssessmentTemplate() {
        return assessmentTemplate;
    }

    public void setAssessmentTemplate(AssessmentTemplate assessmentTemplate) {
        this.assessmentTemplate = assessmentTemplate;
    }

    public String getIndirectManagerAuditComments() {
        return indirectManagerAuditComments;
    }

    public void setIndirectManagerAuditComments(String indirectManagerAuditComments) {
        this.indirectManagerAuditComments = indirectManagerAuditComments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getRankCoefficient() {
        return rankCoefficient;
    }

    public void setRankCoefficient(Double rankCoefficient) {
        this.rankCoefficient = rankCoefficient;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public Double getQuarterlyBonus() {
        return quarterlyBonus;
    }

    public void setQuarterlyBonus(Double quarterlyBonus) {
        this.quarterlyBonus = quarterlyBonus;
    }

    public Double getTimeCoefficient() {
        return timeCoefficient;
    }

    public void setTimeCoefficient(Double timeCoefficient) {
        this.timeCoefficient = timeCoefficient;
    }

    public Integer getTotalSelfScore() {
        return totalSelfScore;
    }

    public void setTotalSelfScore(Integer totalSelfScore) {
        this.totalSelfScore = totalSelfScore;
    }

    public Integer getTotalManagerScore() {
        return totalManagerScore;
    }

    public void setTotalManagerScore(Integer totalManagerScore) {
        this.totalManagerScore = totalManagerScore;
    }

    public enum Status {
        SUBMITTED, // 已提交
        DIRECT_MANAGER_EVALUATED, //直接經理已經評價
        INDIRECT_MANAGER_RECHECK, // 間接經理已經複核
        FINISHED // 已完成
    }
}

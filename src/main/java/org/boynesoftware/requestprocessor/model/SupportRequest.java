package org.boynesoftware.requestprocessor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Used to create support requests, this request is created when a user creates
 * a support request with in an application
 * 
 * @author johnwatters
 *
 */
@Entity
@Table(name = "SUPPORT_REQUEST")
public class SupportRequest implements IHumanRequest {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "SOURCE")
	private String source;

	@Column(name = "FROM_ID")
	private String from;

	@Column(name = "TO_ID")
	private String to;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "COMMENT_TEXT")
	private String comment;

	@Column(name = "REQUEST_TYPE")
	private String type;

	public SupportRequest() {
		super();
	}

	public SupportRequest(String source) {
		super();
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SupportRequest [id=" + id + ", source=" + source + ", from="
				+ from + ", to=" + to + ", subject=" + subject + ", comment="
				+ comment + ", type=" + type + "]";
	}

}

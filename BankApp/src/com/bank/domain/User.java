package com.bank.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "LOGIN")
public class User implements UserDetails {
	// Original props
	@Id
	@GeneratedValue
	@Column(name = "id_user")
	private Long userId;
	@Column(name = "userid")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "date_next_password_change")
	private Date dateOfNextPasswordChange;

	@Column(name = "DATE_LATEST_LOGIN")
	private Date dateLatestLogin;

	@Column(name = "enabled")
	private Boolean enabled;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_authorities", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = { @JoinColumn(name = "id_authority") })
	private Set<Authority> authoritySet = new HashSet<Authority>();
	private transient Collection<GrantedAuthority> authorities;

	// UserDetails methods

	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	public boolean isEnabled() {
		return getEnabled();
	}

	@Transient
	public void setUserAuthorities(List<String> authorities) {
		List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
		for (String role : authorities) {
			listOfAuthorities.add(new GrantedAuthorityImpl(role));
		}
		this.authorities = (Collection<GrantedAuthority>) listOfAuthorities;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authority> getAuthoritySet() {
		return authoritySet;
	}

	public void setAuthoritySet(Set<Authority> authoritySet) {
		this.authoritySet = authoritySet;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Date getDateOfNextPasswordChange() {
		return dateOfNextPasswordChange;
	}

	public void setDateOfNextPasswordChange(Date dateOfNextPasswordChange) {
		this.dateOfNextPasswordChange = dateOfNextPasswordChange;
	}

	public Date getDateLatestLogin() {
		return dateLatestLogin;
	}

	public void setDateLatestLogin(Date dateLatestLogin) {
		this.dateLatestLogin = dateLatestLogin;
	}

}
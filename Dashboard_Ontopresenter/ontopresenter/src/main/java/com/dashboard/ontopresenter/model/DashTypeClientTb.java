package com.dashboard.ontopresenter.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dash_type_client_tb database table.
 * 
 */
@Entity
@Table(name="dash_type_client_tb")
@NamedQuery(name="DashTypeClientTb.findAll", query="SELECT d FROM DashTypeClientTb d")
public class DashTypeClientTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dash_type_client")
	private int idDashTypeClient;

	private String description;

	//bi-directional many-to-one association to ClientTb
	@OneToMany(mappedBy="dashTypeClientTb")
	private List<ClientTb> clientTbs;

	public DashTypeClientTb() {
	}

	public int getIdDashTypeClient() {
		return this.idDashTypeClient;
	}

	public void setIdDashTypeClient(int idDashTypeClient) {
		this.idDashTypeClient = idDashTypeClient;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ClientTb> getClientTbs() {
		return this.clientTbs;
	}

	public void setClientTbs(List<ClientTb> clientTbs) {
		this.clientTbs = clientTbs;
	}

	public ClientTb addClientTb(ClientTb clientTb) {
		getClientTbs().add(clientTb);
		clientTb.setDashTypeClientTb(this);

		return clientTb;
	}

	public ClientTb removeClientTb(ClientTb clientTb) {
		getClientTbs().remove(clientTb);
		clientTb.setDashTypeClientTb(null);

		return clientTb;
	}

}
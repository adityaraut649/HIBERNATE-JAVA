package com.kodnest.OneToMan;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int gid;
	@Column
	String gname;
	@Column
	String gloc;
	@ManyToOne
	@JoinColumn(name = "pid")
	Player player;

	public Game(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Game(int gid, String gname, String gloc, Player player) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gloc = gloc;
		this.player = player;
	}

	public Game(String gname, String gloc, Player player) {
		super();
		this.gname = gname;
		this.gloc = gloc;
		this.player = player;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGloc() {
		return gloc;
	}

	public void setGloc(String gloc) {
		this.gloc = gloc;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Game [gid=" + gid + ", gname=" + gname + ", gloc=" + gloc + ", player=" + player + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gid, gloc, gname, player);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return gid == other.gid && Objects.equals(gloc, other.gloc) && Objects.equals(gname, other.gname)
				&& Objects.equals(player, other.player);
	}

}

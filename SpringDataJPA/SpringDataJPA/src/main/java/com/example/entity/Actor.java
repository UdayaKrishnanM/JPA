package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int actorId;
	private String actorName;
	
	public Actor() {
		
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "actor_movies", joinColumns = { @JoinColumn(name = "actor_id")},inverseJoinColumns = { @JoinColumn(name = "movie_id")})
	private Set<Movie> moviesDone = new HashSet<Movie>();
	
	public Actor(String actorName) {
		super();
		this.actorName = actorName;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Set<Movie> getMoviesDone() {
		return moviesDone;
	}

	public void setMoviesDone(Set<Movie> moviesDone) {
		this.moviesDone = moviesDone;
	}
	
}

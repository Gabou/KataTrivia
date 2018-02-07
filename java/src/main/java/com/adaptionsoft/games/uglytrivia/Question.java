package com.adaptionsoft.games.uglytrivia;

enum Question {
	SPORTS("Sports"),
	SCIENCE("Science"),
	POP("Pop"),
	ROCK("Rock");

	public final String type;

	Question(String type) {

		this.type = type;
	}
}

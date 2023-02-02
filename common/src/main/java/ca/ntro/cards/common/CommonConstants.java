/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.common;

public class CommonConstants {
	
	public static final int INITIAL_WINDOW_WIDTH = 1600;
	public static final int INITIAL_WINDOW_HEIGHT = 900;
	
	public static final double INITIAL_CARD_WIDTH_MILIMETERS = 50;    // CARD_HEIGHT_MILIMETERS * 2/3
	public static final double INITIAL_CARD_HEIGHT_MILIMETERS = 75;
	
	public static final int INITIAL_WORLD_WIDTH_IN_CARDS = 30;
	public static final int INITIAL_WORLD_HEIGHT_IN_CARDS = INITIAL_WORLD_WIDTH_IN_CARDS;

	public static final double INITIAL_WORLD_WIDTH = INITIAL_WORLD_WIDTH_IN_CARDS * INITIAL_CARD_WIDTH_MILIMETERS;
	public static final double INITIAL_WORLD_HEIGHT = INITIAL_WORLD_HEIGHT_IN_CARDS * INITIAL_CARD_HEIGHT_MILIMETERS;   
	
	public static final double INITIAL_TABLETOP_SCREEN_HEIGHT = 200;
	
	public static final String RED = "#e6194B";
	public static final String BLUE = "#4363d8";
	public static final String GREEN = "#3cb44b";
	public static final String BLACK = "#000000";
	
	public static final double SECONDS_BETWEEN_EXECUTION_STEPS = 0.6;
	
	public static final int DEFAULT_NUMBER_OF_EXECUTION_THREADS = 4;

	public static final long ENGINE_THREAD_SLEEP_TIME_MILISECONDS = 200;
	public static final long THREAD_UNRESPONSIVE_TIMEOUT_MILISECONDS = 2000;
	
	public static final String TEST_CASE_DATABASE_DIR = "db";
	public static final String STORAGE_DIR = "_storage";
	
	public static final long TEST_CASE_LOADING_REFRESH_TIMER_DELAY_MILISECONDS = 500;

}

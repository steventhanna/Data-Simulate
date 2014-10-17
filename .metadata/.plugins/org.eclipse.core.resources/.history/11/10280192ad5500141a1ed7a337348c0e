/**
*	<code>Location</code> will define the Location object
*	@date October 15 2014
*	@author Preston Stosur-Bassett
*/

import java.util.Random;

public class Location {
	String city;
	String state;
	String country;

	/**
	*	<code>Location(String theCity, String theState, String theCountry)</code> creates
	*		a location object with the city, state, and country provided
	*/
	public Location(String theCity, String theState, String theCountry) {
		city = theCity;
		state = theState;
		country = theCountry;
	}

	/**
	*	<code>Location(String theState, String theCountry)</code> creates a location 
	*		object with only the state and country provided
	*/
	public Location(String theState, String theCountry) {
		city = null;
		state = theState;
		country = theCountry;
	}

	/**
	*	<code>getLocation</code> returns the properly formatted string with the location
	*	@return String fullLocation Returns the full location properly formatted
	*/
	public String getLocation() {
		String fullLocation;
		if(city == null) {
			//Return only the state and country
			fullLocation = state + ", " + country;
		}
		else {
			//Return the city state and country
			fullLocation = city + ", " + state + ", " + country;
		}

		return fullLocation;
	}

	/**
	*	<code>getCity</code> will return the city, if the city is null returns empty string
	*	@return String validCity Returns city, if city is null, returns empty string.
	*/
	public String getCity() {
		String validCity;
		if(city == null) {
			validCity = city;
		}
		else {
			validCity = " ";
		}

		return validCity;
	}

	/**
	*	<code>getState</code> will return the state
	*	@return String state
	*/
	public String getState()  {
		return state;
	}

	/**
	*	<code>getCountry</code> will return the country
	*	@return String country
	*/
	public String getCountry() {
		return country;
	}

	/**
	*	<code>hasCity</code> will return whether or not this location includes a city
	*	@return boolean hasCity Returns true if the location specifies a city, 
	*		returns false if otherwise
	*/
	public boolean hasCity() {
		boolean hasCity = false;
		if(city == null) {
			hasCity = false;
		}
		else {
			hasCity = true;
		}

		return hasCity;
	}
}
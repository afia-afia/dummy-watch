package afia.nabil.time.service;

import java.beans.PropertyChangeListener;

public interface Listner extends PropertyChangeListener {
	  final static String DIXEME_DE_SECONDE_PROP = "dixième" ;
	  final static String SECONDE_PROP = "seconde" ;
	  final static String MINUTE_PROP = "minute" ;
	  final static String HEURE_PROP = "heure" ;

	public void propertyChange(String propertyName,Object oldValue,Object newValue) ;
}

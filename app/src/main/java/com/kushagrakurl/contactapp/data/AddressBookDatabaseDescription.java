package com.kushagrakurl.contactapp.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.kushagrakurl.contactapp.utils.LogWrapper;


public class AddressBookDatabaseDescription {
	
	/* ContentProvider's name */
	public static final String AUTHORITY = "com.kushagrakurl.contactapp.data";
	
	/* base URI used to interact with the ContentProvider */
	private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
	
	public AddressBookDatabaseDescription() {
		
		LogWrapper.d("constructor");
		LogWrapper.d("AUTHORITY = " + AUTHORITY);
		LogWrapper.d("BASE_CONTENT_URI = " + BASE_CONTENT_URI);
		LogWrapper.d("exit");
	}
	
	// nested class defines contents of the contacts table
	public static final class Contact implements BaseColumns {
	
		public static final String TABLE_NAME = "contacts";
		
		// Uri for the contacts table
		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendEncodedPath
				(TABLE_NAME).build();
		
		// column names for contacts table's columns
		public static final String COLUMN_ID = BaseColumns._ID;
		public static final String COLUMN_NAME = "name";
		public static final String COLUMN_PHONE = "phone";
		public static final String COLUMN_STREET = "street";
		public static final String COLUMN_EMAIL = "email";
		public static final String COLUMN_CITY = "city";
		public static final String COLUMN_STATE = "state";
		public static final String COLUMN_ZIP = "zip";
		
		// creates a Uri for a specific contact
		public static Uri buildContactUri(long id) {
			
			LogWrapper.d("Uri for contact id = " + id);
			return ContentUris.withAppendedId(CONTENT_URI, id);
		}
	}
}

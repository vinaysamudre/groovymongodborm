package main

import groovy.transform.ToString
import org.bson.types.ObjectId
import groovy.transform.Canonical
import com.mongodb.DBCursor

@ToString(includeNames = true, includeFields = true)
@Canonical
class Person extends BasicMongoEntity {
   ObjectId _id
   String firstName
   String secondName
   String surName
   Integer count
   Date dob
   List hobies
   List comments
   Person manager
   List<Person> employees = []
   def validate() {
	 Map errors = [:]
	 if ( firstName.size() < 6 ) {
		errors.firstName = 'firstName size should be < 6'
	 }
	 this.metaClass.errors = errors
	 errors ? false : true
   }


}

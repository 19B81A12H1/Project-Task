package com.example.table;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	 private String Name;
	    private String Description;
	    private LocalDate StartDate;
	    private LocalDate EndDate;
	    
	    
		public long getId() {
			return Id;
		}
		public void setId(long id) {
			Id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public LocalDate getStartDate() {
			return StartDate;
		}
		public void setStartDate(LocalDate startDate) {
			StartDate = startDate;
		}
		public LocalDate getEndDate() {
			return EndDate;
		}
		public void setEndDate(LocalDate endDate) {
			EndDate = endDate;
		}
		
		@Override
		public String toString() {
			return "Office [Id=" + Id + ", Name=" + Name + ", Description=" + Description + ", StartDate=" + StartDate
					+ ", EndDate=" + EndDate + "]";
		}
	    
		
	    

}

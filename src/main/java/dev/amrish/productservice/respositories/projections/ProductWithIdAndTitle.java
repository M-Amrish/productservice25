package dev.amrish.productservice.respositories.projections;

// Somwthing like DTOs except to get data from db and our app
public interface ProductWithIdAndTitle {
    // put getter method for corresponding attributes
    Long getId();
    String getTitle();

   // String getDescription();

}

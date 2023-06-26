package pet.park.controller.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import pet.park.entity.*;
import pet.park.entity.PetPark;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ContributorData {
 private Long contributorId;
 private String contributorName;
 private String contributorEmail;
 private Set<PetParkResponse> petParks = new HashSet<>();

 public ContributorData(Contributor contributor) {
  contributorId = contributor.getContributorId();
  contributorName = contributor.getContributorName();
  contributorEmail = contributor.getContributorEmail();

  for (PetPark petPark : contributor.getPetParks()) {
   petParks.add(new PetParkResponse(petPark));
  }
 }

 @Data
 @NoArgsConstructor
 static class PetParkResponse {
  private Long petParkId;
  private String parkName;
  private String directions;
  private String stateOrProvince;
  private String country;
  private GeoLocation geoLocation;
  private Set<String> amenities = new HashSet<>();

  public PetParkResponse(PetPark petPark) {
   petParkId = petPark.getPetParkId();
   parkName = petPark.getParkName();
   directions = petPark.getDirections();
   stateOrProvince = petPark.getStateOrProvince();
   country = petPark.getCountry();
   geoLocation = new GeoLocation(petPark.getGeoLocation());

   for (Amenity amenity : petPark.getAmenities()) {
    amenities.add(amenity.getAmenity());
   }
  }
 }
}
package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Trail;
import com.launchacademy.reviews.services.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrailSeeder {
  private TrailService trailService;

  @Autowired
  public TrailSeeder(TrailService trailService) {
    this.trailService = trailService;
  }

  public void seed(){
    if(trailService.count() == 0){
       Trail trail1 = new Trail();
       trail1.setName("Middlesex Fells Reservation Loop Trail");
       trail1.setDescription("Middlesex Fells Reservation Loop Trail is a 7.9 mile heavily trafficked"
           + " loop trail located near Medford, Massachusetts that features a lake and is rated as "
           + "moderate. The trail offers a number of activity options and is best used from March "
           + "until November. Dogs are also able to use this trail but must be kept on leash.\n");
       trail1.setDistance(7.9);
       trail1.setDifficulty("Moderate");
       trail1.setElevationGain(757.0);
       trail1.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/19956366/large_00fd782838bef5b35f6e22506c3e44ba.jpg");
       trail1.setZipCode("02148");

        Trail trail2 = new Trail();
        trail2.setName("Mount Cardigan Loop Trail");
        trail2.setDescription("Mount Cardigan Loop Trail is a 3 mile heavily trafficked loop trail "
            + "located near Canaan, New Hampshire that features beautiful wild flowers and is rated "
            + "as moderate. The trail is primarily used for hiking, running, and snowshoeing and is "
            + "best used from April until November. Dogs are also able to use this trail but must be "
            + "kept on leash.\n");
        trail2.setDistance(3.0);
        trail2.setDifficulty("Moderate");
        trail2.setElevationGain(1181.0);
        trail2.setImgUrl("https://cdn-assets.alltrails"
            + ".com/uploads/photo/image/27623677/large_b2fd8b4aaf0a14fc5bc24ed2cef5bc92.jpg");
        trail2.setZipCode("03741");

      trailService.save(trail1);
      trailService.save(trail2);
    }
  }
}

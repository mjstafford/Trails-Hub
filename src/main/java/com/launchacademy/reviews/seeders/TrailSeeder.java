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

      Trail trail3 = new Trail();
      trail3.setName("Anderson Lake and Watson Lake");
      trail3.setDescription("Anderson Lake and Watson Lake is a 5.9 mile heavily trafficked out and back trail located near Concrete, Washington that features beautiful wild flowers and is rated as moderate. The trail is primarily used for hiking and snowshoeing and is best used from May until October. Dogs are also able to use this trail but must be kept on leash.");
      trail3.setDistance(5.9);
      trail3.setDifficulty("Moderate");
      trail3.setElevationGain(1646.0);
      trail3.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/30328785/extra_large_748839c73ca678cc22f24db1af0cebb1.jpg");
      trail3.setZipCode("98144");

      Trail trail4 = new Trail();
      trail4.setName("Scott Paul Trail Loop");
      trail4.setDescription("Scott Paul Trail Loop is a 7.8 mile moderately trafficked loop trail located near Concrete, Washington that features beautiful wild flowers and is rated as difficult. The trail is primarily used for hiking, nature trips, and snowshoeing and is best used from June until September. Dogs are also able to use this trail but must be kept on leash.");
      trail4.setDistance(7.8);
      trail4.setDifficulty("Moderate");
      trail4.setElevationGain(1942.0);
      trail4.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/29417349/extra_large_4034da60e4c8c0056efda5f2bb17fed9.jpg");
      trail4.setZipCode("98237");

      Trail trail5 = new Trail();
      trail5.setName("North Creek Trail");
      trail5.setDescription("North Creek Trail from Mill Creek is a 2.9 mile lightly trafficked out and back trail located near Bothell, Washington that features a great forest setting and is good for all skill levels. The trail is primarily used for hiking, walking, and mountain biking.");
      trail5.setDistance(2.9);
      trail5.setDifficulty("Easy");
      trail5.setElevationGain(157.0);
      trail5.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/26689857/extra_large_b57b4de0dc27f451bfe388a2ebaaf5b7.jpg");
      trail5.setZipCode("98012");

      Trail trail6 = new Trail();
      trail6.setName("Lake Serene");
      trail6.setDescription("Lake Serene and Bridal Veil Falls compete for attention on this trail. Either would be a worthy destination by themselves and combined they are a great day on the trail.");
      trail6.setDistance(8.2);
      trail6.setDifficulty("Hard");
      trail6.setElevationGain(2521.0);
      trail6.setImgUrl("https://www.wta.org/site_images/trip-reports/2021/tripreport-image-2021-06-26-2005161929/@@images/d5d9990e-f20a-4f7f-89d0-897c686b93ae.jpeg");
      trail6.setZipCode("98251");

      Trail trail7 = new Trail();
      trail7.setName("Summit Lake");
      trail7.setDescription("From the trailhead, the Summit Lake Trail begins by climbing up through a young forest still in the process of recovering from a recent harvest. Soon you enter more mature stands of fir and hemlock as the trail swings into long switchbacks up the mountainside. After about a mile of trail reach a junction with the Carbon River Trail and Twin Lake. A short, unmarked trail leads out to lonely Twin Lake, which lacks both a twin and the impressive landscape waiting at Summit Lake.");
      trail7.setDistance(6.1);
      trail7.setDifficulty("Moderate");
      trail7.setElevationGain(1300.0);
      trail7.setImgUrl("https://www.wta.org/go-hiking/hikes/summit-lake/@@image/large");
      trail7.setZipCode("98321");

      Trail trail8 = new Trail();
      trail8.setName("Sun Lakes-Dry Falls");
      trail8.setDescription("e hike involves a circumnavigation of Umatilla Rock, a narrow rock blade that passes below Dry Falls. This area lies midway along the 50-mile Grand Coulee—one of the longest and most spectacular chasms carved out by up to 100 gargantuan Ice Age floods");
      trail8.setDistance(5.0);
      trail8.setDifficulty("Easy");
      trail8.setElevationGain(100.0);
      trail8.setImgUrl("https://www.wta.org/go-hiking/hikes/umatilla-rock-monument-coulee/@@image/large");
      trail8.setZipCode("99115");

      Trail trail9 = new Trail();
      trail9.setName("Mount Watatic and Nutting Hill");
      trail9.setDescription("Mount Watatic and Nutting Hill via Wapack Trail is a 2.8 mile heavily trafficked loop trail located near Ashburnham, Massachusetts that features beautiful wild flowers and is rated as moderate. The trail offers a number of activity options and is accessible year-round. Dogs are also able to use this trail but must be kept on leash.");
      trail9.setDistance(2.8);
      trail9.setDifficulty("Easy");
      trail9.setElevationGain(711.0);
      trail9.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/19210799/extra_large_b307e4f7200a6f0ab64ca9c25a4df6fd.jpg");
      trail9.setZipCode("01430");

      Trail trail10 = new Trail();
      trail10.setName("Mount Townsend");
      trail10.setDescription("Is Mount Townsend popular because there are four trails to the top? Or are there four trails to the top because Mount Townsend is so popular? Let’s just agree it's a popular hike and that there are many reasons for it.");
      trail10.setDistance(8.0);
      trail10.setDifficulty("Moderate");
      trail10.setElevationGain(3010.0);
      trail10.setImgUrl("https://www.wta.org/site_images/hikes/mount-townsend-by-ciams.jpeg/@@images/262513e5-8141-4860-b3d7-4ae216b87447.jpeg");
      trail10.setZipCode("98382");

      Trail trail11 = new Trail();
      trail11.setName("Willard Brook Trail");
      trail11.setDescription("Willard Brook Trail is a 2.2 mile moderately trafficked out and back trail located near Ashby, Massachusetts that features a lake and is good for all skill levels. The trail is primarily used for hiking, walking, nature trips, and birding and is best used from April until October. Dogs are also able to use this trail but must be kept on leash.");
      trail11.setDistance(2.2);
      trail11.setDifficulty("Moderate");
      trail11.setElevationGain(154.0);
      trail11.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/34213960/extra_large_f0af613a990cd95225132657fdc6434b.jpg");
      trail11.setZipCode("01431");

      Trail trail12 = new Trail();
      trail12.setName("Friends Loop Orange and Yellow Trail");
      trail12.setDescription("Friends Loop Orange and Yellow Trail is a 9.2 mile out and back trail located near Ashby, Massachusetts that offers the chance to see wildlife and is rated as moderate. The trail is primarily used for hiking, walking, running, and bird watching.");
      trail12.setDistance(9.2);
      trail12.setDifficulty("Moderate");
      trail12.setElevationGain(1181.0);
      trail12.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/10334148/extra_large_37f71aeeda49e7747328a06a60c24305.jpg");
      trail12.setZipCode("01431");

      Trail trail13 = new Trail();
      trail13.setName("Ashley Reservoir Trail");
      trail13.setDescription("Ashley Reservoir Trail is a 3.5 mile heavily trafficked loop trail located near Holyoke, Massachusetts that features a lake and is good for all skill levels. The trail offers a number of activity options and is accessible year-round.");
      trail13.setDistance(3.5);
      trail13.setDifficulty("Moderate");
      trail13.setElevationGain(65.0);
      trail13.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/19613895/extra_large_308cc436677e927e6ee895983dd3d795.jpg");
      trail13.setZipCode("01040");

      Trail trail14 = new Trail();
      trail14.setName("Mount Williams");
      trail14.setDescription("Mount Williams, Mount Fitch, Mount Greylock, and Stony Ledge is a 12.4 mile heavily trafficked loop trail located near Williamstown, Massachusetts that features a waterfall and is rated as difficult. The trail is primarily used for hiking, camping, nature trips, and bird watching and is best used from March until November. Dogs are also able to use this trail.");
      trail14.setDistance(12.4);
      trail14.setDifficulty("Hard");
      trail14.setElevationGain(3015.0);
      trail14.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/27960264/extra_large_936e0682b1d29abac7e444edca04bf5a.jpg");
      trail14.setZipCode("01267");

      Trail trail15 = new Trail();
      trail15.setName("New England Trail");
      trail15.setDescription("New England Trail: Northampton to Guilford is a 125.1 mile moderately trafficked point-to-point trail located near Easthampton, Massachusetts that features a lake. The trail is rated as difficult and is primarily used for hiking, running, camping, and backpacking.");
      trail15.setDistance(125.1);
      trail15.setDifficulty("Hard");
      trail15.setElevationGain(18024.0);
      trail15.setImgUrl("https://cdn-assets.alltrails.com/uploads/photo/image/19739780/extra_large_5eef2324b92fafc57461381c083a1af2.jpg");
      trail15.setZipCode("01060");

      trailService.save(trail1);
      trailService.save(trail2);
      trailService.save(trail3);
      trailService.save(trail4);
      trailService.save(trail5);
      trailService.save(trail6);
      trailService.save(trail7);
      trailService.save(trail8);
      trailService.save(trail9);
      trailService.save(trail10);
      trailService.save(trail11);
      trailService.save(trail12);
      trailService.save(trail13);
      trailService.save(trail14);
      trailService.save(trail15);
    }
  }
}

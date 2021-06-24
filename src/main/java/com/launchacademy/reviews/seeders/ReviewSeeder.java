package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.Trail;
import com.launchacademy.reviews.models.User;
import com.launchacademy.reviews.services.ReviewService;
import com.launchacademy.reviews.services.TrailService;
import com.launchacademy.reviews.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewSeeder {
  private ReviewService reviewService;
  private TrailService trailService;
  private UserService userService;

  @Autowired
  public ReviewSeeder(ReviewService reviewService,
      TrailService trailService, UserService userService) {
    this.reviewService = reviewService;
    this.trailService = trailService;
    this.userService = userService;
  }

  public void seed() {
    if(reviewService.count() == 0) {
      User user1 = userService.findById(1).get();
      User user2 = userService.findById(2).get();

      Trail trail1 = trailService.findById(1).get();
      Trail trail2 = trailService.findById(2).get();

      Review review1 = new Review();
      review1.setRating(4);
      review1.setComment("Great little hike, we went counter clockwise and it was very chill. Going down was a little tricky but glad to be going down rather than climbing up. Got a little lost on the way down and ended up 1/2 a mi off headed towards Gillsum so we had to hike back up and cross over by the hut. All in all a really enjoyable climb with views that will take your breath away");
      review1.setTrail(trail1);
      review1.setUser(user1);

      Review review2 = new Review();
      review2.setRating(5);
      review2.setComment("Very steep in areas but also very rewarding at the summit. Bring something warm to throw on at the summit as it's almost always windy which makes for some chilly views when you're all sweaty from the ascension. Got multiple compliments on my bug head net, they're available pretty cheap on Amazon. Enjoy your hike");
      review2.setTrail(trail1);
      review2.setUser(user2);

      Review review3 = new Review();
      review3.setRating(4);
      review3.setComment("It was a cloudy day but the view was a beautiful 360 panoramic. The trail s were a little muddy but definitely worth the views at the summit. It had been 35 years since I hiked this trail and it was better than I remembered! Great hike.");
      review3.setTrail(trail2);
      review3.setUser(user2);

      reviewService.save(review1);
      reviewService.save(review2);
      reviewService.save(review3);
    }
  }
}

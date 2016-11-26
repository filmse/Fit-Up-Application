package camt.FitUp.Project.config;

import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.Role;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.repository.FitUpInfoRepository;
import camt.FitUp.Project.repository.UserRepository;
import camt.FitUp.Project.repository.VideoRepository;
import camt.FitUp.Project.service.ImageUtil;
import camt.FitUp.Project.service.ImageUtilForum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/11/2015.
 */
@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    FitUpInfoRepository fitUpInfoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VideoRepository videoRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        FitUpInfo[] initFitUpInfo = {
                new FitUpInfo(1l, "Body Solid Flat Bench", "All the basic barbell and dumbbell exercises then this flat bench\n" +
                        "should be your choice! Increase your strength and flexibility with this ultra-tough workout bench.\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E11.png"), 200)),
                new FitUpInfo(2l, "Hoist CHIN/DIP ASSIST", "The expanded HOIST® HD Dual Series offers a comprehensive solution for fitness facilities where space,\n" +
                        "budget or both are at a premium.\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E22.jpg"), 200)),
                new FitUpInfo(3l, "Hoist Prone Leg Curl", "Dynamic adjustment is the essence behind the new ROC-IT™line from HOIST®.\n" +
                        "Using ROX™ technology, the user becomes an integral part of the exercise by continuously \n" +
                        "adjusting the position of the user with the movement of the exercise arm.", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E33.jpg"), 200)),
                new FitUpInfo(4l, "Hoist Mi6 Fucntional Training System", "The unique and stylish HOIST® Mi6 is a personal pulley gym that is engineered with\n" +
                        "the innovative excellence and aesthetic appeal that the fitness industry has come to\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E44.jpg"), 200)),
                new FitUpInfo(5l, "Gold's Gym XRS 50 Home Gym", "Target your entire body with a wide range of workout options designed to tone your muscles and develop powerful strength.\n" +
                        "Featuring a 112 lb. weight stack, the Golds Gym XRS 50 System delivers a full-range of workout options and up to 280 lbs.\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E55.jpeg"), 200))
        };
        fitUpInfoRepository.save(Arrays.asList(initFitUpInfo));

        Video[] initVideo = {
//                new Video(1l, "Five Step", "The video exercise", "100"),
//                new Video(3l, "Run to Run", "Run on the world", "50"),
//                new Video(4l, "Free style sports", "Sport Spirit", "200")
        };
        videoRepository.save(Arrays.asList(initVideo));

//        ShoppingCart shoppingCart = new ShoppingCart();
//        List<SelectedVideo> selectedVideos = new ArrayList<>();
//        SelectedVideo[] initSelectedVideo = {
//                new SelectedVideo(initVideo[0], 1),
//        };
//        selectedVideos.addAll(Arrays.asList(initSelectedVideo));
//        Calendar calendar = new GregorianCalendar(2015, 4, 7);
//        shoppingCart.setSelectedVideos(selectedVideos);
//        shoppingCart.setPurchaseDate(calendar.getTime());
//        shoppingCart.setId(1L);
//        shoppingCartRepository.save(shoppingCart);

        // add user

        Role adminRole = new Role("admin");
        Role trainerRole = new Role("trainer");
        Role memberRole = new Role("member");

//        Video video1 = new Video(1l, "Five Step", "The video exercise", "100");

        FitUpInfo products1 = new FitUpInfo(1l, "Body Solid Flat Bench", "All the basic barbell and dumbbell exercises then this flat bench\n" +
                "should be your choice! Increase your strength and flexibility with this ultra-tough workout bench.\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E11.png"), 200));
        FitUpInfo products2 = new FitUpInfo(2l, "Hoist CHIN/DIP ASSIST", "The expanded HOIST® HD Dual Series offers a comprehensive solution for fitness facilities where space,\n" +
                "budget or both are at a premium.\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E22.jpg"), 200));
        FitUpInfo products3 = new FitUpInfo(3l, "Hoist Prone Leg Curl", "Dynamic adjustment is the essence behind the new ROC-IT™line from HOIST®.\n" +
                "Using ROX™ technology, the user becomes an integral part of the exercise by continuously \n" +
                "adjusting the position of the user with the movement of the exercise arm.", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E33.jpg"), 200));
        FitUpInfo products4 = new FitUpInfo(4l, "Hoist Mi6 Training System", "The unique and stylish HOIST® Mi6 is a personal pulley gym that is engineered with\n" +
                "the innovative excellence and aesthetic appeal that the fitness industry has come to\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E44.jpg"), 200));
        FitUpInfo products5 = new FitUpInfo(5l, "Gold's Gym XRS 50 Home Gym", "Target your entire body with a wide range of workout options designed to tone your muscles and develop powerful strength.\n" +
                "Featuring a 112 lb. weight stack, the Golds Gym XRS 50 System delivers a full-range of workout options and up to 280 lbs.\n", ImageUtilForum.resizeImage(ImageUtilForum.getImages("picRquip/E55.jpeg"), 200));

        User admin = new User();
        admin.setId(1l);
        admin.setUsername("admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1111");
        admin.getImages().add(ImageUtil.getImage("pic/a.png"));
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User trainer = new User();
        trainer.setId(2l);
        trainer.setUsername("trainer");
        trainer.setEmail("trainer@yahoo.com");
        trainer.setPassword("2222");
        trainer.getImages().add(ImageUtil.getImage("pic/t.png"));
        Set<Role> roles2 = new HashSet<>();
        roles2.add(trainerRole);
        trainer.setRoles(roles2);
        Set<FitUpInfo> infos = new HashSet<>();
        infos.add(products1);
        infos.add(products2);
        infos.add(products3);
        infos.add(products4);
        trainer.setInfos(infos);
//        Set<Video> videos = new HashSet<>();
//        videos.add(video1);
//        trainer.setVideos(videos);

        User trainer1 = new User();
        trainer1.setId(4l);
        trainer1.setUsername("film");
        trainer1.setEmail("film@gmail.com");
        trainer1.setPassword("4432");
        trainer1.getImages().add(ImageUtil.getImage("pic/F.JPG"));
        Set<Role> roles4 = new HashSet<>();
        roles4.add(trainerRole);
        trainer1.setRoles(roles4);

        User member = new User();
        member.setId(3l);
        member.setUsername("member");
        member.setEmail("member@yahoo.com");
        member.setPassword("3333");
        member.getImages().add(ImageUtil.getImage("pic/m.png"));
        Set<Role> roles3 = new HashSet<>();
        roles3.add(memberRole);
        member.setRoles(roles3);

        userRepository.save(admin);
        userRepository.save(trainer);
        userRepository.save(member);
        userRepository.save(trainer1);
    }
}

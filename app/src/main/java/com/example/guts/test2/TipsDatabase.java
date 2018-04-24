package com.example.guts.test2;

import java.util.ArrayList;
        import java.util.List;

public class TipsDatabase {
    List<String> getTips(String Category) {
        List<String> specificTips = new ArrayList<>();
        if (Category.equals("Usage")) {
            specificTips.add("-Always use this app in conjunction with professional medical advise.\n");
            specificTips.add("-This app is to be used alongside, not in place of medical, exercise and diet plans.\n");
            specificTips.add("-Use the Injection function to calculate how many units of insulin to use per meal.\n");
            specificTips.add("-You can keep target blood sugar up to date by using the user page.\n");
        } else if (Category.equals("Diet")) {
            specificTips.add("-The type of carbohydrates you eat is key. Eat whole grain carbs instead of starchy carbs they’re digested slowly, keeping blood sugar levels more even.\n");
            specificTips.add("-Buy lean cuts of beef such as sirloin instead of marbled cuts, and try minced turkey/chicken instead of minced beef.\n");
            specificTips.add("-Use low-fat or fat-free dairy products instead of full-fat varieties.\n");
            specificTips.add("-Limit fried foods and instead use healthy diabetes cooking methods such as baking, grilling, and broiling.\n");
        } else if (Category.equals("Injections")) {
            specificTips.add("-Choose an injection-site on your body that has plenty of fatty tissue.\n");
            specificTips.add("-Lightly pull the skin taught and insert the needle at a 90-degree angle.\n");
            specificTips.add("-Always check needle's sharpness before injecting, if you use a pen injector remember to change the needle with each injection.\n");
            specificTips.add("-If you still find injections painful, try numbing the area by rubbing a piece of ice on the site for a few seconds before the injection.\n");
        } else if (Category.equals("Exercise")) {
            specificTips.add(" -Always carry at least 15 grams of fast-acting insulin on hand in case of Hypoglycemia.\n");
            specificTips.add(" -Wear a medical ID bracelet or carry a medical ID in your pocket.\n");
            specificTips.add(" -If you become shaky, anxious, or lightheaded stop exercising right away and check your blood sugar.\n");
            specificTips.add(" -Choose an injection site less likely to be affected by the working muscles.\n(eg, if you run, do not inject the insulin into the legs as it may result in hypoglycaemia during exercise.)");
        }
        else {
// TODO handle unknown price level
        }
        return specificTips;
    }
}

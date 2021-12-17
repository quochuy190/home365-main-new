package neo.vn.test365children.Untils;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class FragmentUtil {

  public static void popBackStack(FragmentActivity activity) {
    if (activity == null) {
      return;
    }
    activity.getSupportFragmentManager().popBackStack();
  }

  public static void clearAllBackStack(FragmentActivity activity) {
    FragmentManager fm = activity.getSupportFragmentManager();
    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
  }

  /**
   * @param fragmentManager
   * @param fragment
   * @param data
   */
  public static void pushFragment(FragmentManager fragmentManager, int layout, @NonNull Fragment fragment, @Nullable Bundle data) {
    //  DebugLog.e("bundle data:" + data);
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    if (fragment != null && fragment.isAdded()) {
      fragmentTransaction.remove(fragment);    // detach
    }
    fragmentTransaction.replace(layout, fragment);//R.id.content_frame is the layout you want to replace
    fragmentTransaction.commit();
    fragmentTransaction.addToBackStack(null);
  }

  /**
   * @param activity
   * @param fragment
   * @param isPushInsteadOfReplace
   * @param data
   */
  public static void replaceFragmentData(FragmentActivity activity, int layout, @NonNull Fragment fragment,
                                         boolean isPushInsteadOfReplace, @Nullable Bundle data) {
    if (activity == null) {
      return;
    }

    if (data != null) {
      fragment.setArguments(data);
    }

    FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();

    fragmentTransaction.replace(layout, fragment);
    if (isPushInsteadOfReplace) {
      fragmentTransaction.addToBackStack(null);
    }
    fragmentTransaction.commit();
  }

  public static void pushFragmentLayoutMain(FragmentManager manager, int layout, Fragment fragment, String TAG) {
    FragmentTransaction fragmentTransaction = manager.beginTransaction();
    fragmentTransaction.replace(layout, fragment, TAG);//R.id.content_frame is the layout you want to replace
    fragmentTransaction.commit();
    fragmentTransaction.addToBackStack(TAG);
  }

  public static void replaceFragment(FragmentManager manager, int layout,
                                     Fragment fragment, String Back_TAG, String TAG) {

    boolean fragmentPopped = manager.popBackStackImmediate(Back_TAG, 0);
    if (!fragmentPopped) {
      FragmentTransaction fragmentTransaction = manager.beginTransaction();
      fragmentTransaction.replace(layout, fragment, TAG);//R.id.content_frame is the layout you want to replace
      fragmentTransaction.addToBackStack(Back_TAG);
      fragmentTransaction.commit();
    }

  }

  public static void replaceFragmentMain(FragmentActivity activity, Fragment fragment, int id) {
    String backStateName = fragment.getClass().getName();
    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
    transaction.replace(id, fragment);
    // transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    //transaction.addToBackStack(backStateName);
    transaction.commit();
  }
}
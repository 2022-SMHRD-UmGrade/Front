// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNavMain;

  @NonNull
  public final Button btnFare;

  @NonNull
  public final FrameLayout container;

  @NonNull
  public final View divider;

  @NonNull
  public final View divider21;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final CircleImageView imgMypageProfile;

  @NonNull
  public final ImageView imgUmb;

  @NonNull
  public final SliderCardBinding include2;

  @NonNull
  public final LinearLayout linearLayout4;

  @NonNull
  public final ScrollView mainScroll;

  @NonNull
  public final ConstraintLayout myPageLayout;

  @NonNull
  public final Button navCommu;

  @NonNull
  public final Button navMain;

  @NonNull
  public final Button navMore;

  @NonNull
  public final Button navMypage;

  @NonNull
  public final TextView tvCarbonMypageCard;

  @NonNull
  public final TextView tvComment1MypageCard;

  @NonNull
  public final TextView tvComment2MypageCard;

  @NonNull
  public final TextView tvCouponMypageCard;

  @NonNull
  public final TextView tvCouponTextMypageCard;

  @NonNull
  public final TextView tvNickMypageCard;

  @NonNull
  public final TextView tvPointMypageCard;

  @NonNull
  public final TextView tvPointTextMypageCard;

  @NonNull
  public final TextView tvRatingMypageCard;

  @NonNull
  public final TextView tvRatingTextMypageCard;

  @NonNull
  public final TextView tvWelcomeMypageCard;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView,
      @NonNull BottomNavigationView bottomNavMain, @NonNull Button btnFare,
      @NonNull FrameLayout container, @NonNull View divider, @NonNull View divider21,
      @NonNull Guideline guideline2, @NonNull Guideline guideline3,
      @NonNull CircleImageView imgMypageProfile, @NonNull ImageView imgUmb,
      @NonNull SliderCardBinding include2, @NonNull LinearLayout linearLayout4,
      @NonNull ScrollView mainScroll, @NonNull ConstraintLayout myPageLayout,
      @NonNull Button navCommu, @NonNull Button navMain, @NonNull Button navMore,
      @NonNull Button navMypage, @NonNull TextView tvCarbonMypageCard,
      @NonNull TextView tvComment1MypageCard, @NonNull TextView tvComment2MypageCard,
      @NonNull TextView tvCouponMypageCard, @NonNull TextView tvCouponTextMypageCard,
      @NonNull TextView tvNickMypageCard, @NonNull TextView tvPointMypageCard,
      @NonNull TextView tvPointTextMypageCard, @NonNull TextView tvRatingMypageCard,
      @NonNull TextView tvRatingTextMypageCard, @NonNull TextView tvWelcomeMypageCard) {
    this.rootView = rootView;
    this.bottomNavMain = bottomNavMain;
    this.btnFare = btnFare;
    this.container = container;
    this.divider = divider;
    this.divider21 = divider21;
    this.guideline2 = guideline2;
    this.guideline3 = guideline3;
    this.imgMypageProfile = imgMypageProfile;
    this.imgUmb = imgUmb;
    this.include2 = include2;
    this.linearLayout4 = linearLayout4;
    this.mainScroll = mainScroll;
    this.myPageLayout = myPageLayout;
    this.navCommu = navCommu;
    this.navMain = navMain;
    this.navMore = navMore;
    this.navMypage = navMypage;
    this.tvCarbonMypageCard = tvCarbonMypageCard;
    this.tvComment1MypageCard = tvComment1MypageCard;
    this.tvComment2MypageCard = tvComment2MypageCard;
    this.tvCouponMypageCard = tvCouponMypageCard;
    this.tvCouponTextMypageCard = tvCouponTextMypageCard;
    this.tvNickMypageCard = tvNickMypageCard;
    this.tvPointMypageCard = tvPointMypageCard;
    this.tvPointTextMypageCard = tvPointTextMypageCard;
    this.tvRatingMypageCard = tvRatingMypageCard;
    this.tvRatingTextMypageCard = tvRatingTextMypageCard;
    this.tvWelcomeMypageCard = tvWelcomeMypageCard;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomNavMain;
      BottomNavigationView bottomNavMain = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavMain == null) {
        break missingId;
      }

      id = R.id.btnFare;
      Button btnFare = ViewBindings.findChildViewById(rootView, id);
      if (btnFare == null) {
        break missingId;
      }

      id = R.id.container;
      FrameLayout container = ViewBindings.findChildViewById(rootView, id);
      if (container == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.divider21;
      View divider21 = ViewBindings.findChildViewById(rootView, id);
      if (divider21 == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.imgMypageProfile;
      CircleImageView imgMypageProfile = ViewBindings.findChildViewById(rootView, id);
      if (imgMypageProfile == null) {
        break missingId;
      }

      id = R.id.imgUmb;
      ImageView imgUmb = ViewBindings.findChildViewById(rootView, id);
      if (imgUmb == null) {
        break missingId;
      }

      id = R.id.include2;
      View include2 = ViewBindings.findChildViewById(rootView, id);
      if (include2 == null) {
        break missingId;
      }
      SliderCardBinding binding_include2 = SliderCardBinding.bind(include2);

      id = R.id.linearLayout4;
      LinearLayout linearLayout4 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout4 == null) {
        break missingId;
      }

      id = R.id.mainScroll;
      ScrollView mainScroll = ViewBindings.findChildViewById(rootView, id);
      if (mainScroll == null) {
        break missingId;
      }

      id = R.id.myPageLayout;
      ConstraintLayout myPageLayout = ViewBindings.findChildViewById(rootView, id);
      if (myPageLayout == null) {
        break missingId;
      }

      id = R.id.navCommu;
      Button navCommu = ViewBindings.findChildViewById(rootView, id);
      if (navCommu == null) {
        break missingId;
      }

      id = R.id.navMain;
      Button navMain = ViewBindings.findChildViewById(rootView, id);
      if (navMain == null) {
        break missingId;
      }

      id = R.id.navMore;
      Button navMore = ViewBindings.findChildViewById(rootView, id);
      if (navMore == null) {
        break missingId;
      }

      id = R.id.navMypage;
      Button navMypage = ViewBindings.findChildViewById(rootView, id);
      if (navMypage == null) {
        break missingId;
      }

      id = R.id.tvCarbonMypageCard;
      TextView tvCarbonMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvCarbonMypageCard == null) {
        break missingId;
      }

      id = R.id.tvComment1MypageCard;
      TextView tvComment1MypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvComment1MypageCard == null) {
        break missingId;
      }

      id = R.id.tvComment2MypageCard;
      TextView tvComment2MypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvComment2MypageCard == null) {
        break missingId;
      }

      id = R.id.tvCouponMypageCard;
      TextView tvCouponMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvCouponMypageCard == null) {
        break missingId;
      }

      id = R.id.tvCouponTextMypageCard;
      TextView tvCouponTextMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvCouponTextMypageCard == null) {
        break missingId;
      }

      id = R.id.tvNickMypageCard;
      TextView tvNickMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvNickMypageCard == null) {
        break missingId;
      }

      id = R.id.tvPointMypageCard;
      TextView tvPointMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvPointMypageCard == null) {
        break missingId;
      }

      id = R.id.tvPointTextMypageCard;
      TextView tvPointTextMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvPointTextMypageCard == null) {
        break missingId;
      }

      id = R.id.tvRatingMypageCard;
      TextView tvRatingMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvRatingMypageCard == null) {
        break missingId;
      }

      id = R.id.tvRatingTextMypageCard;
      TextView tvRatingTextMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvRatingTextMypageCard == null) {
        break missingId;
      }

      id = R.id.tvWelcomeMypageCard;
      TextView tvWelcomeMypageCard = ViewBindings.findChildViewById(rootView, id);
      if (tvWelcomeMypageCard == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, bottomNavMain, btnFare, container,
          divider, divider21, guideline2, guideline3, imgMypageProfile, imgUmb, binding_include2,
          linearLayout4, mainScroll, myPageLayout, navCommu, navMain, navMore, navMypage,
          tvCarbonMypageCard, tvComment1MypageCard, tvComment2MypageCard, tvCouponMypageCard,
          tvCouponTextMypageCard, tvNickMypageCard, tvPointMypageCard, tvPointTextMypageCard,
          tvRatingMypageCard, tvRatingTextMypageCard, tvWelcomeMypageCard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

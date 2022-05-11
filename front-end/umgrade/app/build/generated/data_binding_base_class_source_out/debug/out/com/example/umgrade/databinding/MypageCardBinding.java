// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MypageCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final View divider;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final CircleImageView imgMypageProfile;

  @NonNull
  public final ImageView imgUmb;

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

  private MypageCardBinding(@NonNull CardView rootView, @NonNull View divider,
      @NonNull Guideline guideline3, @NonNull CircleImageView imgMypageProfile,
      @NonNull ImageView imgUmb, @NonNull TextView tvCarbonMypageCard,
      @NonNull TextView tvComment1MypageCard, @NonNull TextView tvComment2MypageCard,
      @NonNull TextView tvCouponMypageCard, @NonNull TextView tvCouponTextMypageCard,
      @NonNull TextView tvNickMypageCard, @NonNull TextView tvPointMypageCard,
      @NonNull TextView tvPointTextMypageCard, @NonNull TextView tvRatingMypageCard,
      @NonNull TextView tvRatingTextMypageCard, @NonNull TextView tvWelcomeMypageCard) {
    this.rootView = rootView;
    this.divider = divider;
    this.guideline3 = guideline3;
    this.imgMypageProfile = imgMypageProfile;
    this.imgUmb = imgUmb;
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
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static MypageCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MypageCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.mypage_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MypageCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
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

      return new MypageCardBinding((CardView) rootView, divider, guideline3, imgMypageProfile,
          imgUmb, tvCarbonMypageCard, tvComment1MypageCard, tvComment2MypageCard,
          tvCouponMypageCard, tvCouponTextMypageCard, tvNickMypageCard, tvPointMypageCard,
          tvPointTextMypageCard, tvRatingMypageCard, tvRatingTextMypageCard, tvWelcomeMypageCard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityServiceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout constraintLayout6;

  @NonNull
  public final ConstraintLayout constraintLayout7;

  @NonNull
  public final View divider18;

  @NonNull
  public final Guideline guideline18;

  @NonNull
  public final Guideline guideline19;

  @NonNull
  public final TextView tvService1;

  @NonNull
  public final TextView tvService2;

  @NonNull
  public final TextView tvService3;

  @NonNull
  public final TextView tvService4;

  @NonNull
  public final TextView tvService5;

  @NonNull
  public final TextView tvService6;

  @NonNull
  public final TextView tvService7;

  @NonNull
  public final TextView tvService8;

  @NonNull
  public final TextView tvServiceService;

  @NonNull
  public final TextView tvServiceText1;

  @NonNull
  public final TextView tvServiceText2;

  @NonNull
  public final TextView tvServiceTitle;

  private ActivityServiceBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout constraintLayout6, @NonNull ConstraintLayout constraintLayout7,
      @NonNull View divider18, @NonNull Guideline guideline18, @NonNull Guideline guideline19,
      @NonNull TextView tvService1, @NonNull TextView tvService2, @NonNull TextView tvService3,
      @NonNull TextView tvService4, @NonNull TextView tvService5, @NonNull TextView tvService6,
      @NonNull TextView tvService7, @NonNull TextView tvService8,
      @NonNull TextView tvServiceService, @NonNull TextView tvServiceText1,
      @NonNull TextView tvServiceText2, @NonNull TextView tvServiceTitle) {
    this.rootView = rootView;
    this.constraintLayout6 = constraintLayout6;
    this.constraintLayout7 = constraintLayout7;
    this.divider18 = divider18;
    this.guideline18 = guideline18;
    this.guideline19 = guideline19;
    this.tvService1 = tvService1;
    this.tvService2 = tvService2;
    this.tvService3 = tvService3;
    this.tvService4 = tvService4;
    this.tvService5 = tvService5;
    this.tvService6 = tvService6;
    this.tvService7 = tvService7;
    this.tvService8 = tvService8;
    this.tvServiceService = tvServiceService;
    this.tvServiceText1 = tvServiceText1;
    this.tvServiceText2 = tvServiceText2;
    this.tvServiceTitle = tvServiceTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityServiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_service, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityServiceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.constraintLayout6;
      ConstraintLayout constraintLayout6 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout6 == null) {
        break missingId;
      }

      id = R.id.constraintLayout7;
      ConstraintLayout constraintLayout7 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout7 == null) {
        break missingId;
      }

      id = R.id.divider18;
      View divider18 = ViewBindings.findChildViewById(rootView, id);
      if (divider18 == null) {
        break missingId;
      }

      id = R.id.guideline18;
      Guideline guideline18 = ViewBindings.findChildViewById(rootView, id);
      if (guideline18 == null) {
        break missingId;
      }

      id = R.id.guideline19;
      Guideline guideline19 = ViewBindings.findChildViewById(rootView, id);
      if (guideline19 == null) {
        break missingId;
      }

      id = R.id.tvService1;
      TextView tvService1 = ViewBindings.findChildViewById(rootView, id);
      if (tvService1 == null) {
        break missingId;
      }

      id = R.id.tvService2;
      TextView tvService2 = ViewBindings.findChildViewById(rootView, id);
      if (tvService2 == null) {
        break missingId;
      }

      id = R.id.tvService3;
      TextView tvService3 = ViewBindings.findChildViewById(rootView, id);
      if (tvService3 == null) {
        break missingId;
      }

      id = R.id.tvService4;
      TextView tvService4 = ViewBindings.findChildViewById(rootView, id);
      if (tvService4 == null) {
        break missingId;
      }

      id = R.id.tvService5;
      TextView tvService5 = ViewBindings.findChildViewById(rootView, id);
      if (tvService5 == null) {
        break missingId;
      }

      id = R.id.tvService6;
      TextView tvService6 = ViewBindings.findChildViewById(rootView, id);
      if (tvService6 == null) {
        break missingId;
      }

      id = R.id.tvService7;
      TextView tvService7 = ViewBindings.findChildViewById(rootView, id);
      if (tvService7 == null) {
        break missingId;
      }

      id = R.id.tvService8;
      TextView tvService8 = ViewBindings.findChildViewById(rootView, id);
      if (tvService8 == null) {
        break missingId;
      }

      id = R.id.tvServiceService;
      TextView tvServiceService = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceService == null) {
        break missingId;
      }

      id = R.id.tvServiceText1;
      TextView tvServiceText1 = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceText1 == null) {
        break missingId;
      }

      id = R.id.tvServiceText2;
      TextView tvServiceText2 = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceText2 == null) {
        break missingId;
      }

      id = R.id.tvServiceTitle;
      TextView tvServiceTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceTitle == null) {
        break missingId;
      }

      return new ActivityServiceBinding((ConstraintLayout) rootView, constraintLayout6,
          constraintLayout7, divider18, guideline18, guideline19, tvService1, tvService2,
          tvService3, tvService4, tvService5, tvService6, tvService7, tvService8, tvServiceService,
          tvServiceText1, tvServiceText2, tvServiceTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

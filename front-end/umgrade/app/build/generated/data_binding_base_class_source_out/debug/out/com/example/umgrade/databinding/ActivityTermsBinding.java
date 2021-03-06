// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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

public final class ActivityTermsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnTermsClose;

  @NonNull
  public final Guideline guideline13;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final TextView tvPrivacy;

  @NonNull
  public final TextView tvServiceInfo;

  @NonNull
  public final TextView tvTerms;

  private ActivityTermsBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnTermsClose,
      @NonNull Guideline guideline13, @NonNull LinearLayout linearLayout3,
      @NonNull TextView tvPrivacy, @NonNull TextView tvServiceInfo, @NonNull TextView tvTerms) {
    this.rootView = rootView;
    this.btnTermsClose = btnTermsClose;
    this.guideline13 = guideline13;
    this.linearLayout3 = linearLayout3;
    this.tvPrivacy = tvPrivacy;
    this.tvServiceInfo = tvServiceInfo;
    this.tvTerms = tvTerms;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTermsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTermsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_terms, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTermsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnTermsClose;
      Button btnTermsClose = ViewBindings.findChildViewById(rootView, id);
      if (btnTermsClose == null) {
        break missingId;
      }

      id = R.id.guideline13;
      Guideline guideline13 = ViewBindings.findChildViewById(rootView, id);
      if (guideline13 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.tvPrivacy;
      TextView tvPrivacy = ViewBindings.findChildViewById(rootView, id);
      if (tvPrivacy == null) {
        break missingId;
      }

      id = R.id.tvServiceInfo;
      TextView tvServiceInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceInfo == null) {
        break missingId;
      }

      id = R.id.tvTerms;
      TextView tvTerms = ViewBindings.findChildViewById(rootView, id);
      if (tvTerms == null) {
        break missingId;
      }

      return new ActivityTermsBinding((ConstraintLayout) rootView, btnTermsClose, guideline13,
          linearLayout3, tvPrivacy, tvServiceInfo, tvTerms);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

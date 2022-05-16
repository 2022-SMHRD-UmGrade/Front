// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityServiceInfoPopupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline guideline14;

  @NonNull
  public final Guideline guideline15;

  @NonNull
  public final Guideline guideline16;

  @NonNull
  public final Guideline guideline17;

  @NonNull
  public final ServiceinfoCardBinding include;

  @NonNull
  public final Button servicePopupClose;

  @NonNull
  public final TextView textView;

  private ActivityServiceInfoPopupBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline guideline14, @NonNull Guideline guideline15,
      @NonNull Guideline guideline16, @NonNull Guideline guideline17,
      @NonNull ServiceinfoCardBinding include, @NonNull Button servicePopupClose,
      @NonNull TextView textView) {
    this.rootView = rootView;
    this.guideline14 = guideline14;
    this.guideline15 = guideline15;
    this.guideline16 = guideline16;
    this.guideline17 = guideline17;
    this.include = include;
    this.servicePopupClose = servicePopupClose;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityServiceInfoPopupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityServiceInfoPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_service_info_popup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityServiceInfoPopupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline14;
      Guideline guideline14 = ViewBindings.findChildViewById(rootView, id);
      if (guideline14 == null) {
        break missingId;
      }

      id = R.id.guideline15;
      Guideline guideline15 = ViewBindings.findChildViewById(rootView, id);
      if (guideline15 == null) {
        break missingId;
      }

      id = R.id.guideline16;
      Guideline guideline16 = ViewBindings.findChildViewById(rootView, id);
      if (guideline16 == null) {
        break missingId;
      }

      id = R.id.guideline17;
      Guideline guideline17 = ViewBindings.findChildViewById(rootView, id);
      if (guideline17 == null) {
        break missingId;
      }

      id = R.id.include;
      View include = ViewBindings.findChildViewById(rootView, id);
      if (include == null) {
        break missingId;
      }
      ServiceinfoCardBinding binding_include = ServiceinfoCardBinding.bind(include);

      id = R.id.servicePopupClose;
      Button servicePopupClose = ViewBindings.findChildViewById(rootView, id);
      if (servicePopupClose == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityServiceInfoPopupBinding((ConstraintLayout) rootView, guideline14,
          guideline15, guideline16, guideline17, binding_include, servicePopupClose, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPaymentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnPre;

  @NonNull
  public final View divider8;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView tvPaymentTitle;

  private ActivityPaymentBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton btnPre,
      @NonNull View divider8, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull TextView tvPaymentTitle) {
    this.rootView = rootView;
    this.btnPre = btnPre;
    this.divider8 = divider8;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.tvPaymentTitle = tvPaymentTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPaymentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPaymentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_payment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPaymentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnPre;
      ImageButton btnPre = ViewBindings.findChildViewById(rootView, id);
      if (btnPre == null) {
        break missingId;
      }

      id = R.id.divider8;
      View divider8 = ViewBindings.findChildViewById(rootView, id);
      if (divider8 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.tvPaymentTitle;
      TextView tvPaymentTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvPaymentTitle == null) {
        break missingId;
      }

      return new ActivityPaymentBinding((ConstraintLayout) rootView, btnPre, divider8, linearLayout,
          linearLayout2, tvPaymentTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

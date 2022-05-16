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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMoreBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnMoreCommu;

  @NonNull
  public final Button btnMoreNotice;

  @NonNull
  public final Button btnMoreQr;

  @NonNull
  public final Button btnMoreSearch;

  @NonNull
  public final Button btnMoreService;

  @NonNull
  public final Button btnMoreSupport;

  @NonNull
  public final Button btnMoreTerms;

  @NonNull
  public final Button btnMoreUserInfo;

  @NonNull
  public final ConstraintLayout constraintLayout5;

  @NonNull
  public final View divider10;

  @NonNull
  public final View divider11;

  @NonNull
  public final View divider12;

  @NonNull
  public final View divider13;

  @NonNull
  public final View divider14;

  @NonNull
  public final View divider6;

  @NonNull
  public final View divider7;

  @NonNull
  public final View divider8;

  @NonNull
  public final View divider9;

  @NonNull
  public final CircleImageView imgMoreProfile;

  @NonNull
  public final TextView tvMoreNick;

  private FragmentMoreBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnMoreCommu,
      @NonNull Button btnMoreNotice, @NonNull Button btnMoreQr, @NonNull Button btnMoreSearch,
      @NonNull Button btnMoreService, @NonNull Button btnMoreSupport, @NonNull Button btnMoreTerms,
      @NonNull Button btnMoreUserInfo, @NonNull ConstraintLayout constraintLayout5,
      @NonNull View divider10, @NonNull View divider11, @NonNull View divider12,
      @NonNull View divider13, @NonNull View divider14, @NonNull View divider6,
      @NonNull View divider7, @NonNull View divider8, @NonNull View divider9,
      @NonNull CircleImageView imgMoreProfile, @NonNull TextView tvMoreNick) {
    this.rootView = rootView;
    this.btnMoreCommu = btnMoreCommu;
    this.btnMoreNotice = btnMoreNotice;
    this.btnMoreQr = btnMoreQr;
    this.btnMoreSearch = btnMoreSearch;
    this.btnMoreService = btnMoreService;
    this.btnMoreSupport = btnMoreSupport;
    this.btnMoreTerms = btnMoreTerms;
    this.btnMoreUserInfo = btnMoreUserInfo;
    this.constraintLayout5 = constraintLayout5;
    this.divider10 = divider10;
    this.divider11 = divider11;
    this.divider12 = divider12;
    this.divider13 = divider13;
    this.divider14 = divider14;
    this.divider6 = divider6;
    this.divider7 = divider7;
    this.divider8 = divider8;
    this.divider9 = divider9;
    this.imgMoreProfile = imgMoreProfile;
    this.tvMoreNick = tvMoreNick;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMoreBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMoreBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_more, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMoreBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnMoreCommu;
      Button btnMoreCommu = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreCommu == null) {
        break missingId;
      }

      id = R.id.btnMoreNotice;
      Button btnMoreNotice = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreNotice == null) {
        break missingId;
      }

      id = R.id.btnMoreQr;
      Button btnMoreQr = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreQr == null) {
        break missingId;
      }

      id = R.id.btnMoreSearch;
      Button btnMoreSearch = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreSearch == null) {
        break missingId;
      }

      id = R.id.btnMoreService;
      Button btnMoreService = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreService == null) {
        break missingId;
      }

      id = R.id.btnMoreSupport;
      Button btnMoreSupport = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreSupport == null) {
        break missingId;
      }

      id = R.id.btnMoreTerms;
      Button btnMoreTerms = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreTerms == null) {
        break missingId;
      }

      id = R.id.btnMoreUserInfo;
      Button btnMoreUserInfo = ViewBindings.findChildViewById(rootView, id);
      if (btnMoreUserInfo == null) {
        break missingId;
      }

      id = R.id.constraintLayout5;
      ConstraintLayout constraintLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout5 == null) {
        break missingId;
      }

      id = R.id.divider10;
      View divider10 = ViewBindings.findChildViewById(rootView, id);
      if (divider10 == null) {
        break missingId;
      }

      id = R.id.divider11;
      View divider11 = ViewBindings.findChildViewById(rootView, id);
      if (divider11 == null) {
        break missingId;
      }

      id = R.id.divider12;
      View divider12 = ViewBindings.findChildViewById(rootView, id);
      if (divider12 == null) {
        break missingId;
      }

      id = R.id.divider13;
      View divider13 = ViewBindings.findChildViewById(rootView, id);
      if (divider13 == null) {
        break missingId;
      }

      id = R.id.divider14;
      View divider14 = ViewBindings.findChildViewById(rootView, id);
      if (divider14 == null) {
        break missingId;
      }

      id = R.id.divider6;
      View divider6 = ViewBindings.findChildViewById(rootView, id);
      if (divider6 == null) {
        break missingId;
      }

      id = R.id.divider7;
      View divider7 = ViewBindings.findChildViewById(rootView, id);
      if (divider7 == null) {
        break missingId;
      }

      id = R.id.divider8;
      View divider8 = ViewBindings.findChildViewById(rootView, id);
      if (divider8 == null) {
        break missingId;
      }

      id = R.id.divider9;
      View divider9 = ViewBindings.findChildViewById(rootView, id);
      if (divider9 == null) {
        break missingId;
      }

      id = R.id.imgMoreProfile;
      CircleImageView imgMoreProfile = ViewBindings.findChildViewById(rootView, id);
      if (imgMoreProfile == null) {
        break missingId;
      }

      id = R.id.tvMoreNick;
      TextView tvMoreNick = ViewBindings.findChildViewById(rootView, id);
      if (tvMoreNick == null) {
        break missingId;
      }

      return new FragmentMoreBinding((ConstraintLayout) rootView, btnMoreCommu, btnMoreNotice,
          btnMoreQr, btnMoreSearch, btnMoreService, btnMoreSupport, btnMoreTerms, btnMoreUserInfo,
          constraintLayout5, divider10, divider11, divider12, divider13, divider14, divider6,
          divider7, divider8, divider9, imgMoreProfile, tvMoreNick);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
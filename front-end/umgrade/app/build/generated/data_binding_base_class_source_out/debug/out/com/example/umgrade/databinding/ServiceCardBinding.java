// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ServiceCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button btnServiceCard;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final TextView tvServiceCard1;

  @NonNull
  public final TextView tvServiceCard2;

  private ServiceCardBinding(@NonNull CardView rootView, @NonNull Button btnServiceCard,
      @NonNull ImageView imageView3, @NonNull TextView tvServiceCard1,
      @NonNull TextView tvServiceCard2) {
    this.rootView = rootView;
    this.btnServiceCard = btnServiceCard;
    this.imageView3 = imageView3;
    this.tvServiceCard1 = tvServiceCard1;
    this.tvServiceCard2 = tvServiceCard2;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ServiceCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ServiceCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.service_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ServiceCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnServiceCard;
      Button btnServiceCard = ViewBindings.findChildViewById(rootView, id);
      if (btnServiceCard == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.tvServiceCard1;
      TextView tvServiceCard1 = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceCard1 == null) {
        break missingId;
      }

      id = R.id.tvServiceCard2;
      TextView tvServiceCard2 = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceCard2 == null) {
        break missingId;
      }

      return new ServiceCardBinding((CardView) rootView, btnServiceCard, imageView3, tvServiceCard1,
          tvServiceCard2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

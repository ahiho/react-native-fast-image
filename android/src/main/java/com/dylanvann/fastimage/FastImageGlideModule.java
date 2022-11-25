package com.dylanvann.fastimage;

import android.content.Context;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.GlideBuilder;

// We need an AppGlideModule to be present for progress events to work.
@GlideModule
public final class FastImageGlideModule extends AppGlideModule {
  @Override
  public void applyOptions(Context context, GlideBuilder builder) {
    int memoryCacheSizeBytes = 1024 * 1024 * 32; // 20 MB
    builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));

    int diskCacheSizeBytes = 1024 * 1024 * 60; // 60 MB
    builder.setDiskCache(new InternalCacheDiskCacheFactory(context, diskCacheSizeBytes));
  }
}

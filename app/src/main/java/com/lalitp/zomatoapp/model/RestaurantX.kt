package com.lalitp.zomatoapp.model


import com.google.gson.annotations.SerializedName

data class RestaurantX(
    @SerializedName("all_reviews")
    val allReviews: AllReviews?,
    @SerializedName("all_reviews_count")
    val allReviewsCount: Int?,
    @SerializedName("apikey")
    val apikey: String?,
    @SerializedName("average_cost_for_two")
    val averageCostForTwo: Int?,
    @SerializedName("book_again_url")
    val bookAgainUrl: String?,
    @SerializedName("book_form_web_view_url")
    val bookFormWebViewUrl: String?,
    @SerializedName("cuisines")
    val cuisines: String?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("deeplink")
    val deeplink: String?,
    @SerializedName("establishment")
    val establishment: List<String?>?,
    @SerializedName("establishment_types")
    val establishmentTypes: List<Any?>?,
    @SerializedName("events_url")
    val eventsUrl: String?,
    @SerializedName("featured_image")
    val featuredImage: String?,
    @SerializedName("has_online_delivery")
    val hasOnlineDelivery: Int?,
    @SerializedName("has_table_booking")
    val hasTableBooking: Int?,
    @SerializedName("highlights")
    val highlights: List<String?>?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("include_bogo_offers")
    val includeBogoOffers: Boolean?,
    @SerializedName("is_book_form_web_view")
    val isBookFormWebView: Int?,
    @SerializedName("is_delivering_now")
    val isDeliveringNow: Int?,
    @SerializedName("is_table_reservation_supported")
    val isTableReservationSupported: Int?,
    @SerializedName("is_zomato_book_res")
    val isZomatoBookRes: Int?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("medio_provider")
    val medioProvider: Int?,
    @SerializedName("menu_url")
    val menuUrl: String?,
    @SerializedName("mezzo_provider")
    val mezzoProvider: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("offers")
    val offers: List<Any?>?,
    @SerializedName("opentable_support")
    val opentableSupport: Int?,
    @SerializedName("phone_numbers")
    val phoneNumbers: String?,
    @SerializedName("photo_count")
    val photoCount: Int?,
    @SerializedName("photos")
    val photos: List<Photo?>?,
    @SerializedName("photos_url")
    val photosUrl: String?,
    @SerializedName("price_range")
    val priceRange: Int?,
    @SerializedName("R")
    val r: R?,
    @SerializedName("switch_to_order_menu")
    val switchToOrderMenu: Int?,
    @SerializedName("thumb")
    val thumb: String?,
    @SerializedName("timings")
    val timings: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("user_rating")
    val userRating: UserRating?
)
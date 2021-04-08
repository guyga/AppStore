package com.example.appstore.database;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "new_free_android_apps_table")
public class App implements Parcelable
{
	private double rating;

	@PrimaryKey
	@NonNull
	private String package_name;

	@TypeConverters(StringListConverter.class)
	private List<String> screenshots;

	@TypeConverters(StringListConverter.class)
	private List<String> badges;

	private String developer;

	private String price_currency;

	private String icon_72;

	private String title;

	@TypeConverters(StringListConverter.class)
	private List<String> interactive_elements;

	private String privacy_policy;

	private String category;

	private int version_code;

	private String version;

	private int size;

	@TypeConverters(StringListConverter.class)
	private List<String> price_i18n_countries;

	private int cat_int;

	private String created;

	private String market_update;

	private String market_url;

	private String cat_key;

	private String downloads;

	@TypeConverters(StringListConverter.class)
	private List<String> cat_keys;

	@TypeConverters(StringListConverter.class)
	private List<String> from_developer;

	private boolean iap;

	private String website;

	private String promo_video;

	@TypeConverters(StringListConverter.class)
	private List<String> content_descriptors;

	private String what_is_new;

	private int number_ratings;

	@TypeConverters(StringListConverter.class)
	private List<String> similar;

	private int screenshots_count;

	private String market_status;

	private String short_desc;

	private long downloads_max;

	private int price_numeric;

	private boolean contains_ads;

	private String description;

	private String price;

	@TypeConverters(StringListConverter.class)
	private List<String> i18n_lang;

	private long downloads_min;

	private String promo_video_image;

	private String icon;

	private String lang;

	private int cat_type;

	private String content_rating;

	private int ratings_4;

	private int ratings_5;

	private int ratings_2;

	private int ratings_3;

	private int ratings_1;

	public App()
	{
	}

	protected App(Parcel in)
	{
		rating = in.readDouble();
		package_name = in.readString();
		screenshots = in.createStringArrayList();
		badges = in.createStringArrayList();
		developer = in.readString();
		price_currency = in.readString();
		icon_72 = in.readString();
		title = in.readString();
		interactive_elements = in.createStringArrayList();
		privacy_policy = in.readString();
		category = in.readString();
		version_code = in.readInt();
		version = in.readString();
		size = in.readInt();
		price_i18n_countries = in.createStringArrayList();
		cat_int = in.readInt();
		created = in.readString();
		market_update = in.readString();
		market_url = in.readString();
		cat_key = in.readString();
		downloads = in.readString();
		cat_keys = in.createStringArrayList();
		from_developer = in.createStringArrayList();
		iap = in.readByte() != 0;
		website = in.readString();
		promo_video = in.readString();
		content_descriptors = in.createStringArrayList();
		what_is_new = in.readString();
		number_ratings = in.readInt();
		similar = in.createStringArrayList();
		screenshots_count = in.readInt();
		market_status = in.readString();
		short_desc = in.readString();
		downloads_max = in.readLong();
		price_numeric = in.readInt();
		contains_ads = in.readByte() != 0;
		description = in.readString();
		price = in.readString();
		i18n_lang = in.createStringArrayList();
		downloads_min = in.readLong();
		promo_video_image = in.readString();
		icon = in.readString();
		lang = in.readString();
		cat_type = in.readInt();
		content_rating = in.readString();
		ratings_4 = in.readInt();
		ratings_5 = in.readInt();
		ratings_2 = in.readInt();
		ratings_3 = in.readInt();
		ratings_1 = in.readInt();
	}

	public double getRating()
	{
		return rating;
	}

	public void setRating(double rating)
	{
		this.rating = rating;
	}

	public String getPackage_name()
	{
		return package_name;
	}

	public void setPackage_name(String package_name)
	{
		this.package_name = package_name;
	}

	public List<String> getScreenshots()
	{
		return screenshots;
	}

	public void setScreenshots(List<String> screenshots)
	{
		this.screenshots = screenshots;
	}

	public List<String> getBadges()
	{
		return badges;
	}

	public void setBadges(List<String> badges)
	{
		this.badges = badges;
	}

	public String getDeveloper()
	{
		return developer;
	}

	public void setDeveloper(String developer)
	{
		this.developer = developer;
	}

	public String getPrice_currency()
	{
		return price_currency;
	}

	public void setPrice_currency(String price_currency)
	{
		this.price_currency = price_currency;
	}

	public String getIcon_72()
	{
		return icon_72;
	}

	public void setIcon_72(String icon_72)
	{
		this.icon_72 = icon_72;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public List<String> getInteractive_elements()
	{
		return interactive_elements;
	}

	public void setInteractive_elements(List<String> interactive_elements)
	{
		this.interactive_elements = interactive_elements;
	}

	public String getPrivacy_policy()
	{
		return privacy_policy;
	}

	public void setPrivacy_policy(String privacy_policy)
	{
		this.privacy_policy = privacy_policy;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public int getVersion_code()
	{
		return version_code;
	}

	public void setVersion_code(int version_code)
	{
		this.version_code = version_code;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public List<String> getPrice_i18n_countries()
	{
		return price_i18n_countries;
	}

	public void setPrice_i18n_countries(List<String> price_i18n_countries)
	{
		this.price_i18n_countries = price_i18n_countries;
	}

	public int getCat_int()
	{
		return cat_int;
	}

	public void setCat_int(int cat_int)
	{
		this.cat_int = cat_int;
	}

	public String getCreated()
	{
		return created;
	}

	public void setCreated(String created)
	{
		this.created = created;
	}

	public String getMarket_update()
	{
		return market_update;
	}

	public void setMarket_update(String market_update)
	{
		this.market_update = market_update;
	}

	public String getMarket_url()
	{
		return market_url;
	}

	public void setMarket_url(String market_url)
	{
		this.market_url = market_url;
	}

	public String getCat_key()
	{
		return cat_key;
	}

	public void setCat_key(String cat_key)
	{
		this.cat_key = cat_key;
	}

	public String getDownloads()
	{
		return downloads;
	}

	public void setDownloads(String downloads)
	{
		this.downloads = downloads;
	}

	public List<String> getCat_keys()
	{
		return cat_keys;
	}

	public void setCat_keys(List<String> cat_keys)
	{
		this.cat_keys = cat_keys;
	}

	public List<String> getFrom_developer()
	{
		return from_developer;
	}

	public void setFrom_developer(List<String> from_developer)
	{
		this.from_developer = from_developer;
	}

	public boolean isIap()
	{
		return iap;
	}

	public void setIap(boolean iap)
	{
		this.iap = iap;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getPromo_video()
	{
		return promo_video;
	}

	public void setPromo_video(String promo_video)
	{
		this.promo_video = promo_video;
	}

	public List<String> getContent_descriptors()
	{
		return content_descriptors;
	}

	public void setContent_descriptors(List<String> content_descriptors)
	{
		this.content_descriptors = content_descriptors;
	}

	public String getWhat_is_new()
	{
		return what_is_new;
	}

	public void setWhat_is_new(String what_is_new)
	{
		this.what_is_new = what_is_new;
	}

	public int getNumber_ratings()
	{
		return number_ratings;
	}

	public void setNumber_ratings(int number_ratings)
	{
		this.number_ratings = number_ratings;
	}

	public List<String> getSimilar()
	{
		return similar;
	}

	public void setSimilar(List<String> similar)
	{
		this.similar = similar;
	}

	public int getScreenshots_count()
	{
		return screenshots_count;
	}

	public void setScreenshots_count(int screenshots_count)
	{
		this.screenshots_count = screenshots_count;
	}

	public String getMarket_status()
	{
		return market_status;
	}

	public void setMarket_status(String market_status)
	{
		this.market_status = market_status;
	}

	public String getShort_desc()
	{
		return short_desc;
	}

	public void setShort_desc(String short_desc)
	{
		this.short_desc = short_desc;
	}

	public long getDownloads_max()
	{
		return downloads_max;
	}

	public void setDownloads_max(long downloads_max)
	{
		this.downloads_max = downloads_max;
	}

	public int getPrice_numeric()
	{
		return price_numeric;
	}

	public void setPrice_numeric(int price_numeric)
	{
		this.price_numeric = price_numeric;
	}

	public boolean isContains_ads()
	{
		return contains_ads;
	}

	public void setContains_ads(boolean contains_ads)
	{
		this.contains_ads = contains_ads;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public List<String> getI18n_lang()
	{
		return i18n_lang;
	}

	public void setI18n_lang(List<String> i18n_lang)
	{
		this.i18n_lang = i18n_lang;
	}

	public long getDownloads_min()
	{
		return downloads_min;
	}

	public void setDownloads_min(long downloads_min)
	{
		this.downloads_min = downloads_min;
	}

	public String getPromo_video_image()
	{
		return promo_video_image;
	}

	public void setPromo_video_image(String promo_video_image)
	{
		this.promo_video_image = promo_video_image;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getLang()
	{
		return lang;
	}

	public void setLang(String lang)
	{
		this.lang = lang;
	}

	public int getCat_type()
	{
		return cat_type;
	}

	public void setCat_type(int cat_type)
	{
		this.cat_type = cat_type;
	}

	public String getContent_rating()
	{
		return content_rating;
	}

	public void setContent_rating(String content_rating)
	{
		this.content_rating = content_rating;
	}

	public int getRatings_4()
	{
		return ratings_4;
	}

	public void setRatings_4(int ratings_4)
	{
		this.ratings_4 = ratings_4;
	}

	public int getRatings_5()
	{
		return ratings_5;
	}

	public void setRatings_5(int ratings_5)
	{
		this.ratings_5 = ratings_5;
	}

	public int getRatings_2()
	{
		return ratings_2;
	}

	public void setRatings_2(int ratings_2)
	{
		this.ratings_2 = ratings_2;
	}

	public int getRatings_3()
	{
		return ratings_3;
	}

	public void setRatings_3(int ratings_3)
	{
		this.ratings_3 = ratings_3;
	}

	public int getRatings_1()
	{
		return ratings_1;
	}

	public void setRatings_1(int ratings_1)
	{
		this.ratings_1 = ratings_1;
	}

	@Override
	public int describeContents()
	{
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeDouble(rating);
		dest.writeString(package_name);
		dest.writeStringList(screenshots);
		dest.writeStringList(badges);
		dest.writeString(developer);
		dest.writeString(price_currency);
		dest.writeString(icon_72);
		dest.writeString(title);
		dest.writeStringList(interactive_elements);
		dest.writeString(privacy_policy);
		dest.writeString(category);
		dest.writeInt(version_code);
		dest.writeString(version);
		dest.writeInt(size);
		dest.writeStringList(price_i18n_countries);
		dest.writeInt(cat_int);
		dest.writeString(created);
		dest.writeString(market_update);
		dest.writeString(market_url);
		dest.writeString(cat_key);
		dest.writeString(downloads);
		dest.writeStringList(cat_keys);
		dest.writeStringList(from_developer);
		dest.writeByte((byte) (iap ? 1 : 0));
		dest.writeString(website);
		dest.writeString(promo_video);
		dest.writeStringList(content_descriptors);
		dest.writeString(what_is_new);
		dest.writeInt(number_ratings);
		dest.writeStringList(similar);
		dest.writeInt(screenshots_count);
		dest.writeString(market_status);
		dest.writeString(short_desc);
		dest.writeLong(downloads_max);
		dest.writeInt(price_numeric);
		dest.writeByte((byte) (contains_ads ? 1 : 0));
		dest.writeString(description);
		dest.writeString(price);
		dest.writeStringList(i18n_lang);
		dest.writeLong(downloads_min);
		dest.writeString(promo_video_image);
		dest.writeString(icon);
		dest.writeString(lang);
		dest.writeInt(cat_type);
		dest.writeString(content_rating);
		dest.writeInt(ratings_4);
		dest.writeInt(ratings_5);
		dest.writeInt(ratings_2);
		dest.writeInt(ratings_3);
		dest.writeInt(ratings_1);
	}

	public static final Creator<App> CREATOR = new Creator<App>()
	{
		@Override
		public App createFromParcel(Parcel in)
		{
			return new App(in);
		}

		@Override
		public App[] newArray(int size)
		{
			return new App[size];
		}
	};
}

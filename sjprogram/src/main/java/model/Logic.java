package model;

public class SiteLogic {
	public void like(Site site) {
		int count = site.getLike();
		site.setLike(count + 1);
	}

	public void dislike(Site site) {
		int count = site.getDislike();
		site.setDislike(count + 1);
	}

}
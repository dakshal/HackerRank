// Write your Checker class here

class Checker implements Comparator<Player> {
	@Override
	public int compare(Player p1, Player p2) {
		return p1.score != p2.score ? (p2.score - p1.score) : p1.name.compareTo(p2.name);
	}
}
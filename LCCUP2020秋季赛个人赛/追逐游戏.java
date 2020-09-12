/*
秋游中的小力和小扣设计了一个追逐游戏。他们选了秋日市集景区中的 N 个景点，景点编号为 1~N。此外，他们还选择了 N 条小路，满足任意两个景点之间都可以通过小路互相到达，且不存在两条连接景点相同的小路。整个游戏场景可视作一个无向连通图，记作二维数组 edges，数组中以 [a,b] 形式表示景点 a 与景点 b 之间有一条小路连通。

小力和小扣只能沿景点间的小路移动。小力的目标是在最快时间内追到小扣，小扣的目标是尽可能延后被小力追到的时间。游戏开始前，两人分别站在两个不同的景点 startA 和 startB。每一回合，小力先行动，小扣观察到小力的行动后再行动。小力和小扣在每回合可选择以下行动之一：

移动至相邻景点
留在原地
如果小力追到小扣（即两人于某一时刻出现在同一位置），则游戏结束。若小力可以追到小扣，请返回最少需要多少回合；若小力无法追到小扣，请返回 -1。

注意：小力和小扣一定会采取最优移动策略。
*/

class Solution {
    final int MOD = 1000000007;
	int n;
	List<Integer>[] g;
	Set<Integer> circle;

	int[] atoall;
	int[] btoall;

	List<Integer> dfslist;
	boolean[] dfsvisited;
	boolean dfsfound;

	public int chaseGame(int[][] edges, int startA, int startB) {
		startA--;
		startB--;
		n = edges.length;

		g = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0] - 1;
			int to = edges[i][1] - 1;

			g[from].add(to);
			g[to].add(from);
            if ((from == startA && to == startB) || (from == startB && to == startA)) {
				return 1;
			}
		}

		circle = new HashSet<Integer>();

		atoall = getDistToAll(g, startA);
		btoall = getDistToAll(g, startB);

		getCircle();
		if (circle.size() > 3) {

			int btocircleIndex = 0;
			int btocircleDist = n + 10;

			for (int i = 0; i < n; i++) {
				if (circle.contains(i) && btoall[i] < btocircleDist) {
					btocircleIndex = i;
					btocircleDist = btoall[i];
				}
			}

			if (btocircleDist == 0) {
				return -1;
			}
			if (atoall[btocircleIndex] - btocircleDist > 1) {
				return -1;
			}
		}

		int ans = getFiniteAns(startB);
		//check();

		return ans;
	}

	public int getFiniteAns(int startB) {
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];

		dist[startB] = 0;
		visited[startB] = true;

		int ans = atoall[startB];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startB);
		while (queue.size() > 0) {
			int now = queue.poll();
			ans = Math.max(ans, atoall[now]);

			for (Integer next : g[now]) {
				if (visited[next] == false) {
					visited[next] = true;
					dist[next] = dist[now] + 1;

					if (atoall[next] - dist[next] > 1) {
						queue.add(next);
					}
				}
			}
		}

		return ans;
	}

	public int[] getDistToAll(List<Integer>[] g, int start) {
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];

		dist[start] = 0;
		visited[start] = true;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (queue.size() > 0) {
			int now = queue.poll();
			for (Integer next : g[now]) {
				if (visited[next] == false) {
					visited[next] = true;
					dist[next] = dist[now] + 1;
					queue.add(next);
				}
			}
		}

		return dist;
	}

	public void getCircle() {
		dfslist = new ArrayList<Integer>();
		dfsvisited = new boolean[n];

		dfsToFindCircle(0, -1);

		/*
		 * for (Integer i : circle) { System.out.print(i + " "); }
		 * System.out.println();
		 */
	}

	public void dfsToFindCircle(int now, int pre) {
		// System.out.printf("dfs %d\n", now);
		dfsvisited[now] = true;
		dfslist.add(now);

		for (Integer next : g[now]) {
			if (next == pre) {
				continue;
			}
			if (dfsvisited[next] == false && dfsfound == false) {
				dfsToFindCircle(next, now);
			} else {
				for (int i = 0; i < dfslist.size(); i++) {
					int k = dfslist.get(i);
					// System.out.printf(" dfslist:%d\n", k);
					if (k == next) {
						for (int j = i; j < dfslist.size(); j++) {
							circle.add(dfslist.get(j));
							dfsfound = true;
						}
						break;
					}
				}
			}
		}

		dfslist.remove(dfslist.size() - 1);
	}
}
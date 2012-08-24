class ShortestPath{
	private double[] distTo;
	private Edge[] edgeTo; //last edge on shortest path from s~>v
	private IndexMinPQ<Double> pq; //priority queue of vertices

	public ShortestPath(EdgeWeightedGraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new Edge[G.V()];

		for(int v=0;v < G.V();v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}

		distTo[s] = 0.0;

		//relaxation of vertices

		pq = new IndexMinPQ<Double>(G.V());
		pq.insert(s,distTo[s]);

		while(!pq.isEmpty()){
			int v = pq.delMin();
			System.out.println("Vertex Added::" + v);
			for(Edge e : G.adj(v)){
				relax(e,v);
			}
		}
	}

	//relax edge e and update pq if changed

	private void relax(Edge e,int v){
		int w = e.other(v);
		System.out.println( v + "-" + w);
		System.out.println("Checking data for node " + w + " :: " + distTo[w] + " NEW " + (distTo[v] + e.weight()));
		System.out.println(distTo[w] > distTo[v] + e.weight());
		if(distTo[w] > distTo[v] + e.weight()){
			System.out.println("Updating data for node " + w + " :: " + distTo[w] + " NEW " + (distTo[v] + e.weight()));
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;



			if(pq.contains(w)){
				pq.change(w,distTo[w]);
			}else{
				pq.insert(w,distTo[w]);
			}
		}
	}

	 // length of shortest path from s to v
    public double distTo(int v) {
        return distTo[v];
    }

    // is there a path from s to v?
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    // shortest path from s to v as an Iterable, null if no such path
    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        int l = 0;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.other(v)]) {
        	System.out.println("COUNT " + l);
        	System.out.println(e);
        	l++;
        	System.out.println("POINT " + v);
        	v = e.other(v);
        	System.out.println("POINT " + v);
            path.push(e);
        }
        return path;
    }


}
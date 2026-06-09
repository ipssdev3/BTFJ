/**
 * BTF, by Timothy A. Davis, Copyright (C) 2004-2011, University of Florida,
 * with support from Sandia National Laboratories.  All Rights Reserved.
 * Copyright (C) 2011 Richard Lincoln
 */

package edu.ufl.cise.btf.tdouble;

final class Dbtf_profile {

	private Dbtf_profile() {
	}

	static boolean enabled() {
		return Boolean.getBoolean("btfj.profile");
	}

	static long now() {
		return enabled() ? System.nanoTime() : 0L;
	}

	static void order(int n, int nz, int nmatch, int nblocks,
			long totalNs, long maxtransNs, long singularNs, long strongNs) {
		if (!enabled()) return;
		System.out.println("btfjProfileOrder,n=" + n +
				",nz=" + nz +
				",nmatch=" + nmatch +
				",nblocks=" + nblocks +
				",totalMs=" + ms(totalNs) +
				",maxtransMs=" + ms(maxtransNs) +
				",singularFixMs=" + ms(singularNs) +
				",strongcompMs=" + ms(strongNs));
	}

	static void maxtrans(int nrow, int ncol, int nz, int nmatch, double work,
			long totalNs, long allocNs, long initNs, long augmentNs) {
		if (!enabled()) return;
		System.out.println("btfjProfileMaxtrans,nrow=" + nrow +
				",ncol=" + ncol +
				",nz=" + nz +
				",nmatch=" + nmatch +
				",work=" + work +
				",totalMs=" + ms(totalNs) +
				",allocMs=" + ms(allocNs) +
				",initMs=" + ms(initNs) +
				",augmentMs=" + ms(augmentNs));
	}

	static void strongcomp(int n, int nz, int nblocks,
			long totalNs, long allocNs, long initNs, long dfsNs,
			long boundaryNs, long permNs, long qNs) {
		if (!enabled()) return;
		System.out.println("btfjProfileStrongcomp,n=" + n +
				",nz=" + nz +
				",nblocks=" + nblocks +
				",totalMs=" + ms(totalNs) +
				",allocMs=" + ms(allocNs) +
				",initMs=" + ms(initNs) +
				",dfsMs=" + ms(dfsNs) +
				",boundaryMs=" + ms(boundaryNs) +
				",permMs=" + ms(permNs) +
				",qMs=" + ms(qNs));
	}

	private static double ms(long ns) {
		return ns / 1_000_000.0;
	}
}

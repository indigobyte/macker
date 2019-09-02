/*______________________________________________________________________________
 * 
 * net.innig.util.CompositeMultiMap
 * 
 *______________________________________________________________________________
 * 
 * Copyright 2002 Paul Cantrell
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * (1) Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 * (2) Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *     distribution. 
 *
 * (3) The name of the author may not be used to endorse or promote
 *     products derived from this software without specific prior
 *     written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *_______________________________________________________________________________
 */

package de.andrena.tools.macker.util.collect;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * A multi-map implementation which uses {@link HashMap} and {@link HashSet}.
 * <table style="cellpadding: 4px; cellspacing: 2px; border-style: none; background-color: #338833; width: 90%;">
 * <caption>Additional info</caption>
* <tr>
 * <td style="background-color: #EEEEEE;">
 * <b>Maturity:</b> This is a 90% mature API, and a stable implementation. It
 * performs well in formal testing, but has not undergone real-world testing.</td>
 * </tr>
 * <tr>
 * <td style="background-color: #EEEEEE;">
 * <b>Plans:</b> There are no current plans to expand or revise this class's
 * functionality.</td>
 * </tr>
 * </table>
 */
public class HashMultiMap<K, V> extends CompositeMultiMap<K, V> {
	public HashMultiMap() {
		super(HashMap.class, HashSet.class);
	}

	public HashMultiMap(MultiMap<K, V> multimap) {
		super(HashMap.class, HashSet.class, multimap);
	}

	public HashMultiMap(Map<K, V> map) {
		super(HashMap.class, HashSet.class, map);
	}
}

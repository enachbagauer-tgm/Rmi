/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package client;

import compute.Task;
import java.io.Serializable;
import java.math.BigInteger;

public class Fibonacci implements Task<BigInteger>, Serializable {

    private static final long serialVersionUID = 227L;

    /** digits of precision after the decimal point */
    private final int n;
    
    /**
     * Construct a task to calculate pi to the specified
     * precision.
     */
    public Fibonacci(int n) {
        this.n = n;
    }

    /**
     * Calculate pi.
     */
    public BigInteger execute() {
        return computeFibonacci(n);
    }
    
    
    public static BigInteger computeFibonacci (int n){
		n = Integer.parseInt(""+n);
    	BigInteger prepre = new BigInteger("0");
		BigInteger pre = new BigInteger("1");
		BigInteger out = new BigInteger("1");
    	try {
			
			if (n >= 2) {
				for (int i = 3; i <= n; i++) {
					prepre = pre;
					pre = out;
					out = prepre.add(pre);
				}
			} else if (n >= 0) {
				out = new BigInteger(Integer.toString(n));
			} else {
				out = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return out;
    	
    }
}

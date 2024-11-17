package com.example.thread.jcip;

import com.example.thread.jcip.annotations.GuardedBy;
import com.example.thread.jcip.annotations.ThreadSafe;
import java.math.BigInteger;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * SynchronizedFactorizer
 * <p>
 * Servlet that caches last result, but with unnacceptably poor concurrency
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class SynchronizedFactorizer extends GenericServlet implements Servlet {

  @GuardedBy("this")
  private BigInteger lastNumber;
  @GuardedBy("this")
  private BigInteger[] lastFactors;

  public synchronized void service(ServletRequest req,
      ServletResponse resp) {
    BigInteger i = extractFromRequest(req);
    if (i.equals(lastNumber)) {
      encodeIntoResponse(resp, lastFactors);
    } else {
      BigInteger[] factors = factor(i);
      lastNumber = i;
      lastFactors = factors;
      encodeIntoResponse(resp, factors);
    }
  }

  void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
  }

  BigInteger extractFromRequest(ServletRequest req) {
    return new BigInteger("7");
  }

  BigInteger[] factor(BigInteger i) {
    // Doesn't really factor
    return new BigInteger[]{i};
  }
}


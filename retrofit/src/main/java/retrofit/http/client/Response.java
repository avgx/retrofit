package retrofit.http.client;

import java.util.Collections;
import java.util.List;
import retrofit.http.Header;

/** An HTTP response. */
public final class Response {
  private final int status;
  private final String reason;
  private final List<Header> headers;
  private final byte[] body;

  public Response(int status, String reason, List<Header> headers, byte[] body) {
    if (status < 100) {
      throw new IllegalArgumentException("Invalid status code: " + status);
    }
    if (reason == null) {
      throw new IllegalArgumentException("Reason must not be null.");
    }
    if (headers == null) {
      throw new IllegalArgumentException("Headers must not be null.");
    }
    if (body == null) {
      throw new IllegalArgumentException("Body must not be null.");
    }

    this.body = body;
    this.status = status;
    this.reason = reason;
    this.headers = Collections.unmodifiableList(headers);
  }

  /** Status line code. */
  public int getStatus() {
    return status;
  }

  /** Status line reason phrase. */
  public String getReason() {
    return reason;
  }

  /** An unmodifiable collection of headers. */
  public List<Header> getHeaders() {
    return headers;
  }

  /** Response body. May be {@code null}. */
  public byte[] getBody() {
    return body;
  }
}
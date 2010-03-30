package org.protege.owl.server.connection.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.protege.owl.server.api.RemoteOntologyRevisions;
import org.protege.owl.server.api.Server;
import org.protege.owl.server.exception.RemoteOntologyCreationException;

public class MarkedOntologyServlet extends HttpServlet {
    private static final long serialVersionUID = -6826342078353081611L;
    
    public static final String PATH="/ontology/revision";
    
    private Server server;

    public MarkedOntologyServlet(Server server) {
        this.server = server;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String encoded = request.getPathInfo();
            StringTokenizer tokenizer = new StringTokenizer(encoded, "/");
            String shortName = tokenizer.nextToken();
            Integer revision = Integer.parseInt(tokenizer.nextToken());
            for (RemoteOntologyRevisions revisions: server.getOntologyList()) {
                if (revisions.getShortName().equals(shortName)) {
                    InputStream in = server.getOntologyStream(revisions.getOntologyName(), revision);
                    in = new BufferedInputStream(in);
                    OutputStream out = new BufferedOutputStream(response.getOutputStream());
                    int c;
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                    out.flush();
                    out.close();
                    return;
                }
            }
        }
        catch (RemoteOntologyCreationException e) {
            throw new IOException(e);
        }
    }
}
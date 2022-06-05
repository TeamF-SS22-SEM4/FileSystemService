package at.fhv.ec.communication.rest;

import at.fhv.ec.application.api.FileService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.NoSuchElementException;

@Path("/files")
public class FileController {
    @Inject
    FileService fileService;

    @GET
    @Path("/exampleFile")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(responseCode = "404", description = "When the file cannot be found.")
    @APIResponseSchema(value = byte[].class, responseCode = "200")
    @Operation(operationId = "getExampleFile", description = "Responds with the MP3 file as bytes")
    public Response getFile() {
        try {
            byte[] exampleFile = fileService.getExampleFile();
            return Response.ok(exampleFile).build();
        } catch (NoSuchElementException | IOException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

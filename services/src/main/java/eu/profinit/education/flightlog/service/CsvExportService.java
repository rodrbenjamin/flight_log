package eu.profinit.education.flightlog.service;

import eu.profinit.education.flightlog.to.FileExportTo;

public interface CsvExportService {

    FileExportTo getAllFlightsAsCsv();
}

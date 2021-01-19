  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Lido ${lido.nome}" admin="false">
  <sm:header/>
  <div id="wrapper">
    <sm:sidebarLido/>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column ">

      <!-- Main Content -->
      <div class=section-top-border">
        <h3 class="mb-30">Affluenza settimanale per il lido: <b>${lido.nome}</b></h3>
        <div class="progress-table-wrap">
          <div class=section-top-border">
            <div class="progress-table-wrap">
              <div class="progress-table">
                <div class="table-head">
                  <div class="country" style="margin: 10px">Giorni</div>
                  <div class="visit">Prenotazioni</div>
                  <div class="percentage">Grafico</div>
                </div>
                <div class="table-row">
                  <div class="country" style="margin: 10px">Luned&igrave;</div>
                  <div class="visit">42</div>
                  <div class="percentage">
                    <div class="progress">
                      <div class="progress-bar color-1" role="progressbar" style="width: 30%" aria-valuenow="30"
                           aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>

                <div class="table-row">
                  <div class="country" style="margin: 10px">Marted&igrave;</div>
                  <div class="visit">32</div>
                  <div class="percentage">
                    <div class="progress">
                      <div class="progress-bar color-2" role="progressbar" style="width: 20%" aria-valuenow="20"
                           aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="table-row">

                  <div class="country" style="margin: 10px">Mercoled&igrave;</div>
                  <div class="visit">12</div>
                  <div class="percentage">
                    <div class="progress">
                      <div class="progress-bar color-3" role="progressbar" style="width: 15%" aria-valuenow="15"
                           aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="table-row">

                  <div class="country" style="margin: 10px">Gioved&igrave;</div>
                  <div class="visit">50</div>
                  <div class="percentage">
                    <div class="progress">
                      <div class="progress-bar color-4" role="progressbar" style="width: 50%" aria-valuenow="50"
                           aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="table-row">

                  <div class="country" style="margin: 10px">Venerd&igrave;</div>
                  <div class="visit">66</div>
                  <div class="percentage">
                    <div class="progress">
                      <div class="progress-bar color-5" role="progressbar" style="width: 60%" aria-valuenow="60"
                           aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="table-row">

                  <div class="country" style="margin: 10px">Sabato</div>
                  <div class="visit">205</div>
                  <div class="percentage">
                    <div class="progress">
                      <div class="progress-bar color-6" role="progressbar" style="width: 80%" aria-valuenow="80"
                           aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="table-row">

                  <div class="country" style="margin: 10px">Domenica</div>
                  <div class="visit">352</div>
                  <div class="percentage">
                    <div class="progress">
                      <div class="progress-bar color-7" role="progressbar" style="width: 90%" aria-valuenow="90"
                           aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
      <sm:footer/>
    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->
</sm:layout>

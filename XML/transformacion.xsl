<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    
    <!-- Plantilla principal -->
    <xsl:template match="/">
        <html>
        <head>
            <title>Información de la Universidad</title>
            <style>
                table {
                    border-collapse: collapse;
                    width: 100%;
                }
                th, td {
                    border: 1px solid black;
                    padding: 8px;
                    text-align: left;
                }
                th {
                    background-color: #f2f2f2;
                }
            </style>
        </head>
        <body>
            <h1>Estudiantes</h1>
            <table>
                <tr>
                    <th>Carnet</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Semestre Ingreso</th>
                    <th>Promedio</th>
                </tr>
                <xsl:for-each select="Universidad/Estudiantes/Estudiante">
                    <tr>
                        <td><xsl:value-of select="Carnet"/></td>
                        <td><xsl:value-of select="Nombre"/></td>
                        <td><xsl:value-of select="Apellido"/></td>
                        <td><xsl:value-of select="SemestreIngreso"/></td>
                        <td><xsl:value-of select="Promedio"/></td>
                    </tr>
                </xsl:for-each>
            </table>
            
            <h1>Total y Porcentaje</h1>
            <!-- Calcular el total de estudiantes y el promedio general -->
            <xsl:variable name="totalEstudiantes" select="count(Universidad/Estudiantes/Estudiante)"/>
            <xsl:variable name="sumaPromedios" select="sum(Universidad/Estudiantes/Estudiante/Promedio)"/>
            <xsl:variable name="promedioGeneral" select="$sumaPromedios div $totalEstudiantes"/>
            
            <p>Total de Estudiantes: <xsl:value-of select="$totalEstudiantes"/></p>
            <p>Promedio General: <xsl:value-of select="format-number($promedioGeneral, '#.##')"/></p>
            <p>Porcentaje de Estudiantes con promedio mayor a 3.5: 
                <xsl:variable name="estudiantesMayor35" select="count(Universidad/Estudiantes/Estudiante[Promedio &gt; 3.5])"/>
                <xsl:value-of select="format-number(($estudiantesMayor35 div $totalEstudiantes) * 100, '#.##')"/>%
            </p>

            <h1>Estudiantes con Promedio Mayor a 3.5</h1>
            <table>
                <tr>
                    <th>Carnet</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Semestre Ingreso</th>
                    <th>Promedio</th>
                </tr>
                <xsl:for-each select="Universidad/Estudiantes/Estudiante[Promedio &gt; 3.5]">
                    <tr>
                        <td><xsl:value-of select="Carnet"/></td>
                        <td><xsl:value-of select="Nombre"/></td>
                        <td><xsl:value-of select="Apellido"/></td>
                        <td><xsl:value-of select="SemestreIngreso"/></td>
                        <td><xsl:value-of select="Promedio"/></td>
                    </tr>
                </xsl:for-each>
            </table>

            <h1>Asignaturas</h1>
            <table>
                <tr>
                    <th>Nombre Asignatura</th>
                    <th>Intensidad Semanal</th>
                    <th>Semestre</th>
                </tr>
                <xsl:for-each select="Universidad/Asignaturas/Asignatura">
                    <tr>
                        <td><xsl:value-of select="NombreAsignatura"/></td>
                        <td><xsl:value-of select="IntensidadSemanal"/></td>
                        <td><xsl:value-of select="Semestre"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

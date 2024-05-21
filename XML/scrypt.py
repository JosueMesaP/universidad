from lxml import etree

# Cargar el XML y XSL
xml = etree.parse('universidad.xml')
xsl = etree.parse('transformacion.xsl')

# Crear el transformador
transform = etree.XSLT(xsl)

# Aplicar la transformación
html = transform(xml)

# Guardar el resultado en un archivo HTML
with open('universidad.html', 'wb') as f:
    f.write(etree.tostring(html, pretty_print=True, method="html", encoding='UTF-8'))

print("Transformación completada. El archivo 'universidad.html' ha sido generado.")
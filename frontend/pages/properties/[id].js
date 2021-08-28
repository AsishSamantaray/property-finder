const SingleProperty = ({ property }) => {
  console.log(property);
  return (
    <div>
      <h1>{property.fullAddress}</h1>
    </div>
  );
};

export default SingleProperty;

export const getStaticPaths = async () => {
  const res = await fetch("http://localhost:8080/api/properties");
  const data = await res.json();

  const paths = data.map((property) => {
    return {
      params: {
        id: property.propertyId,
      },
    };
  });

  return {
    paths,
    fallback: false,
  };
};

export const getStaticProps = async ({ params }) => {
  const res = await fetch("http://localhost:8080/api/property/" + params.id);
  const data = await res.json();

  return {
    props: {
      property: data,
    },
  };
};
